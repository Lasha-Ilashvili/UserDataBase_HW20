package com.example.userdatabase_hw20.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userdatabase_hw20.data.common.Resource
import com.example.userdatabase_hw20.domain.model.User
import com.example.userdatabase_hw20.domain.use_case.database.DeleteUserUseCase
import com.example.userdatabase_hw20.domain.use_case.database.InsertUserUseCase
import com.example.userdatabase_hw20.domain.use_case.database.UpdateUserUseCase
import com.example.userdatabase_hw20.domain.use_case.use_case_model.DatabaseUseCases
import com.example.userdatabase_hw20.domain.use_case.use_case_model.InputValidatorUseCases
import com.example.userdatabase_hw20.presentation.event.UserEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val databaseUseCases: DatabaseUseCases,
    private val inputValidatorUseCases: InputValidatorUseCases
) : ViewModel() {

    private val _users = MutableSharedFlow<Resource>()
    val users: SharedFlow<Resource> get() = _users

    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.AddUser -> {
                addUser(
                    event.user,
                    databaseUseCases.insertUserUseCase
                )
            }

            is UserEvent.RemoveUser -> {
                removeUser(
                    event.user,
                    databaseUseCases.removeUserUseCase
                )
            }

            is UserEvent.UpdateUser -> {
                updateUser(
                    event.user,
                    databaseUseCases.updateUserUseCase
                )
            }
        }
    }


    private fun addUser(user: User, insertUseCase: InsertUserUseCase) {
        if (!areFieldsValid(user)) {
//            updateErrorMessage(message = "Fields are not valid!")
            return
        }

        executeUseCase(
            user,
            insertUseCase::invoke
        )
    }

    private fun removeUser(user: User, deleteUser: DeleteUserUseCase) {
        executeUseCase(
            user,
            deleteUser::invoke
        )
    }

    private fun updateUser(user: User, updateUser: UpdateUserUseCase) {
        val isEmailValid = inputValidatorUseCases.emailValidatorUseCase(user.email)

        if (!isEmailValid) {
            return
        }

        viewModelScope.launch {
            val oldUser = databaseUseCases.getUserUseCase(user.email!!)

            val updatedUser = user.copy(
                firstName = user.firstName ?: oldUser?.firstName,
                lastName = user.lastName ?: oldUser?.lastName,
                age = user.age ?: oldUser?.age,
                email = user.email
            )

            executeUseCase(
                updatedUser,
                updateUser::invoke
            )
        }
    }

    private fun executeUseCase(user: User, useCase: suspend (User) -> Flow<Resource>) {
        viewModelScope.launch {
            useCase(user).collect {
                _users.emit(it)
            }
        }
    }

    private fun areFieldsValid(user: User): Boolean {
        val areFieldsValid: Boolean

        with(inputValidatorUseCases) {
            val isEmailValid = emailValidatorUseCase(user.email)
            val isNameValid = nameValidatorUseCase(user.firstName, user.lastName)
            val isAgeValid = ageValidatorUseCase(user.age)

            areFieldsValid =
                listOf(isEmailValid, isNameValid, isAgeValid)
                    .all { it }
        }

        return areFieldsValid
    }
}
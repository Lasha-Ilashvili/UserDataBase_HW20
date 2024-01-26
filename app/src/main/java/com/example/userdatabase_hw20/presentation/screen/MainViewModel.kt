package com.example.userdatabase_hw20.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userdatabase_hw20.domain.model.User
import com.example.userdatabase_hw20.domain.use_case.DatabaseUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val databaseUseCases: DatabaseUseCases
) : ViewModel() {

    val testFlow = databaseUseCases.getAllUseCase()

    fun onEvent(user: User) {
        testIt(user)
    }

    private fun testIt(user: User) {
        viewModelScope.launch {
            databaseUseCases.insertUserUseCase(user)
        }
    }
}
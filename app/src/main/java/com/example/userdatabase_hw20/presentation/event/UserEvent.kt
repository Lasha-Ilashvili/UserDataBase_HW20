package com.example.userdatabase_hw20.presentation.event

import com.example.userdatabase_hw20.domain.model.User

sealed class UserEvent {
    data class AddUser(val user: User) : UserEvent()
    data class RemoveUser(val user: User) : UserEvent()
    data class UpdateUser(val user: User) : UserEvent()
}
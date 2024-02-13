package com.example.userdatabase_hw20.data.mapper

import com.example.userdatabase_hw20.data.model.UserEntity
import com.example.userdatabase_hw20.domain.model.User


fun UserEntity.toDomain() = User(
    firstName = firstName,
    lastName = lastName,
    age = age,
    email = email
)

fun User.toData() = UserEntity(
    firstName = firstName ?: "",
    lastName = lastName ?: "",
    age = age ?: 0,
    email = email ?: ""
)
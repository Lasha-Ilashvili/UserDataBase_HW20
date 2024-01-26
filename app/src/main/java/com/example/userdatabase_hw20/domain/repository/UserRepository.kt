package com.example.userdatabase_hw20.domain.repository

import com.example.userdatabase_hw20.data.model.UserEntity
import com.example.userdatabase_hw20.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getAll(): Flow<List<User>>

    suspend fun insertUser(user: UserEntity)

    suspend fun deleteUser(user: UserEntity)

    suspend fun updateUser(user: UserEntity)
}
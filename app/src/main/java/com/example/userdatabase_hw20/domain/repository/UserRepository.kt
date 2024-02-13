package com.example.userdatabase_hw20.domain.repository

import com.example.userdatabase_hw20.data.common.Resource
import com.example.userdatabase_hw20.data.model.UserEntity
import com.example.userdatabase_hw20.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUserCount(): Int

    suspend fun getUser(email: String): User?

    suspend fun insertUser(user: UserEntity): Flow<Resource>

    suspend fun deleteUser(user: UserEntity): Flow<Resource>

    suspend fun updateUser(user: UserEntity): Flow<Resource>
}
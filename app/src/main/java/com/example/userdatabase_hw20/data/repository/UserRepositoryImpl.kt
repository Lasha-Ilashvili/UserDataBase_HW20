package com.example.userdatabase_hw20.data.repository

import com.example.userdatabase_hw20.data.common.HandleResponse
import com.example.userdatabase_hw20.data.common.Resource
import com.example.userdatabase_hw20.data.dao.UserDao
import com.example.userdatabase_hw20.data.mapper.toDomain
import com.example.userdatabase_hw20.data.model.UserEntity
import com.example.userdatabase_hw20.domain.model.User
import com.example.userdatabase_hw20.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val handleResponse: HandleResponse
) : UserRepository {

    override suspend fun getUserCount(): Int {
        return userDao.getUserCount()
    }

    override suspend fun getUser(email: String): User? {
        return try {
            userDao.getUser(email).toDomain()
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun insertUser(user: UserEntity): Flow<Resource> {
        return handleResponse.safeDatabaseCall {
            userDao.insertUser(user).toInt()
        }
    }

    override suspend fun deleteUser(user: UserEntity): Flow<Resource> {
        return handleResponse.safeDatabaseCall {
            userDao.deleteUser(user)
        }
    }

    override suspend fun updateUser(user: UserEntity): Flow<Resource> {
        return handleResponse.safeDatabaseCall {
            userDao.updateUser(user)
        }
    }
}

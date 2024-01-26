package com.example.userdatabase_hw20.data.repository

import android.database.sqlite.SQLiteConstraintException
import android.util.Log.d
import com.example.userdatabase_hw20.data.dao.UserDao
import com.example.userdatabase_hw20.data.mapper.toDomain
import com.example.userdatabase_hw20.data.model.UserEntity
import com.example.userdatabase_hw20.domain.model.User
import com.example.userdatabase_hw20.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override fun getAll(): Flow<List<User>> {
        return userDao.getAll().map {
            it.map { userEntity ->
                userEntity.toDomain()
            }
        }
    }

    override suspend fun insertUser(user: UserEntity) {
        try {
            val k = userDao.insertUser(user)
            d("CatchExcept", k.toString())
        } catch (e: SQLiteConstraintException) {
            d("CatchExcept", e.localizedMessage ?: "")
        }
    }

    override suspend fun deleteUser(user: UserEntity) {
        val rowsDeleted = userDao.deleteUser(user)

        if (rowsDeleted == 0) {
            d("CatchExcept", "0")
        }
    }

    override suspend fun updateUser(user: UserEntity) {
        val rowsUpdated = userDao.updateUser(user)
        if (rowsUpdated == 0) {
            d("CatchExcept", "0")
        }
    }
}

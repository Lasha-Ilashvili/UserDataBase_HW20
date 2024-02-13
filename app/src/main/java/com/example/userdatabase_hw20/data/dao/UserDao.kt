package com.example.userdatabase_hw20.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.userdatabase_hw20.data.model.UserEntity

@Dao
interface UserDao {

    @Query("SELECT COUNT(*) FROM UserEntity")
    suspend fun getUserCount(): Int

    @Query("SELECT * FROM UserEntity WHERE email LIKE :email LIMIT 1")
    suspend fun getUser(email: String): UserEntity

    @Insert
    suspend fun insertUser(user: UserEntity): Long

    @Delete
    suspend fun deleteUser(user: UserEntity): Int

    @Update
    suspend fun updateUser(user: UserEntity): Int
}
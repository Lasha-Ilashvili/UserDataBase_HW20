package com.example.userdatabase_hw20.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.userdatabase_hw20.data.dao.UserDao
import com.example.userdatabase_hw20.data.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
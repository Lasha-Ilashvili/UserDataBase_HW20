package com.example.userdatabase_hw20.di

import com.example.userdatabase_hw20.data.common.HandleResponse
import com.example.userdatabase_hw20.data.dao.UserDao
import com.example.userdatabase_hw20.data.repository.UserRepositoryImpl
import com.example.userdatabase_hw20.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(
        userDao: UserDao,
        handleResponse: HandleResponse
    ): UserRepository {
        return UserRepositoryImpl(userDao, handleResponse)
    }
}
package com.example.userdatabase_hw20.domain.use_case.database

import com.example.userdatabase_hw20.data.common.Resource
import com.example.userdatabase_hw20.data.mapper.toData
import com.example.userdatabase_hw20.domain.model.User
import com.example.userdatabase_hw20.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User): Flow<Resource> {
        return userRepository.updateUser(user.toData())
    }
}
package com.example.userdatabase_hw20.domain.use_case

import com.example.userdatabase_hw20.data.mapper.toData
import com.example.userdatabase_hw20.domain.model.User
import com.example.userdatabase_hw20.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User) {
        userRepository.updateUser(user.toData())
    }
}
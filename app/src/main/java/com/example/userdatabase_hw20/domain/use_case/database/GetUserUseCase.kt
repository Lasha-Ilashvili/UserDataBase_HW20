package com.example.userdatabase_hw20.domain.use_case.database

import com.example.userdatabase_hw20.domain.model.User
import com.example.userdatabase_hw20.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(email: String): User? {
        return userRepository.getUser(email)
    }
}
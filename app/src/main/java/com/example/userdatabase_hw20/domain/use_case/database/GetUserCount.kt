package com.example.userdatabase_hw20.domain.use_case.database

import com.example.userdatabase_hw20.domain.repository.UserRepository
import javax.inject.Inject

class GetUserCount @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): Int {
        return userRepository.getUserCount()
    }
}
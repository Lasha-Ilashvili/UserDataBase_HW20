package com.example.userdatabase_hw20.domain.use_case

import com.example.userdatabase_hw20.domain.model.User
import com.example.userdatabase_hw20.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(): Flow<List<User>> {
        return userRepository.getAll()
    }
}
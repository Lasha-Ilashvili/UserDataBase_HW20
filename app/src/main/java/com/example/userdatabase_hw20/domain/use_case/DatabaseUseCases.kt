package com.example.userdatabase_hw20.domain.use_case

import javax.inject.Inject

data class DatabaseUseCases @Inject constructor(
    val insertUserUseCase: InsertUserUseCase,
    val deleteUserUseCase: DeleteUserUseCase,
    val updateUserUseCase: UpdateUserUseCase,
    val getAllUseCase: GetAllUseCase
)
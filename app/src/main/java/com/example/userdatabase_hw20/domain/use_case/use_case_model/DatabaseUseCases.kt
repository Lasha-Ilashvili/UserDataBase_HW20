package com.example.userdatabase_hw20.domain.use_case.use_case_model

import com.example.userdatabase_hw20.domain.use_case.database.DeleteUserUseCase
import com.example.userdatabase_hw20.domain.use_case.database.GetUserCount
import com.example.userdatabase_hw20.domain.use_case.database.GetUserUseCase
import com.example.userdatabase_hw20.domain.use_case.database.InsertUserUseCase
import com.example.userdatabase_hw20.domain.use_case.database.UpdateUserUseCase
import javax.inject.Inject

data class DatabaseUseCases @Inject constructor(
    val insertUserUseCase: InsertUserUseCase,
    val removeUserUseCase: DeleteUserUseCase,
    val updateUserUseCase: UpdateUserUseCase,
    val getUserCount: GetUserCount,
    val getUserUseCase: GetUserUseCase
)
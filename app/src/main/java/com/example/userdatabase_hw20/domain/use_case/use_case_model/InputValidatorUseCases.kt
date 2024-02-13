package com.example.userdatabase_hw20.domain.use_case.use_case_model

import com.example.userdatabase_hw20.domain.use_case.validator.AgeValidatorUseCase
import com.example.userdatabase_hw20.domain.use_case.validator.EmailValidatorUseCase
import com.example.userdatabase_hw20.domain.use_case.validator.NameValidatorUseCase
import javax.inject.Inject

data class InputValidatorUseCases @Inject constructor(
    val emailValidatorUseCase: EmailValidatorUseCase,
    val nameValidatorUseCase: NameValidatorUseCase,
    val ageValidatorUseCase: AgeValidatorUseCase
)

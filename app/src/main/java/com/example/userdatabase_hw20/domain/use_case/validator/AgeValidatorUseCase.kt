package com.example.userdatabase_hw20.domain.use_case.validator

import javax.inject.Inject

class AgeValidatorUseCase @Inject constructor() {
    operator fun invoke(age: Int?): Boolean {
        return age != null && age > 0
    }
}

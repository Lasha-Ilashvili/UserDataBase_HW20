package com.example.userdatabase_hw20.domain.use_case.validator

import javax.inject.Inject

class NameValidatorUseCase @Inject constructor() {
    operator fun invoke(firstName: String?, lastName: String?): Boolean {
        return !firstName.isNullOrBlank() && !lastName.isNullOrBlank()
    }
}

package com.example.userdatabase_hw20.data.common

sealed interface Resource {
    data object Success : Resource
    data object Error : Resource
}
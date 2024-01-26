package com.example.userdatabase_hw20.data.common

import android.database.sqlite.SQLiteConstraintException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class HandleResponse {

    fun <T : Number> safeDatabaseCall(call: suspend () -> T): Flow<Resource<T>> = flow {
        emit(Resource.Loading(loading = true))

        try {
            val result = call.invoke()
//            if(result != 0)
//            emit(Resource.Success(data = result))
        } catch (e: SQLiteConstraintException) {
            emit(Resource.Error(errorMessage = "Database constraint violation: ${e.localizedMessage}"))
        } catch (e: Exception) {
            emit(Resource.Error(errorMessage = "An unexpected error occurred: ${e.localizedMessage}"))
        } finally {
            emit(Resource.Loading(loading = false))
        }
    }
}
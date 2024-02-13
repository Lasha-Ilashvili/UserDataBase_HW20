package com.example.userdatabase_hw20.data.common

import android.database.sqlite.SQLiteConstraintException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class HandleResponse {

    fun safeDatabaseCall(call: suspend () -> Int): Flow<Resource> = flow {
        try {
            val result = call.invoke()

            if (result != 0)
                emit(Resource.Success)
            else
                emit(Resource.Error)
        } catch (e: SQLiteConstraintException) {
            emit(Resource.Error)
        } catch (e: Exception) {
            emit(Resource.Error)
        }
    }
}
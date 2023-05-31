package com.example.todolist_.core.repository

import android.util.Log
import com.example.todolist_.core.model.BaseResourceEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DbCall : IDbCall {

    override fun <T : Any> dbCall(call: suspend () -> T): Flow<BaseResourceEvent<T>> = flow {
        emit(BaseResourceEvent.Loading())
        var response: T? = null
        try {
            response = call()
            Log.d("RESPONSE",response.toString())
        } catch (t: Throwable) {
            emit(BaseResourceEvent.Error(t.message!!))
        }
        if (response == null) {
            emit(BaseResourceEvent.Error("Herhangi bir data bulunamadı!"))
        } else {
            emit(BaseResourceEvent.Success(response))
        }
    }
}
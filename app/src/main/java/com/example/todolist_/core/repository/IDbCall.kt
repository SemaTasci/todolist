package com.example.todolist_.core.repository

import com.example.todolist_.core.model.BaseResourceEvent
import kotlinx.coroutines.flow.Flow

interface IDbCall {

    fun <T : Any> dbCall(
        call: suspend () -> T
    ): Flow<BaseResourceEvent<T>>
}
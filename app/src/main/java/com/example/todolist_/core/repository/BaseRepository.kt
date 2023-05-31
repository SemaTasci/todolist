package com.example.todolist_.core.repository

import com.example.todolist_.core.ext.convertRersourceEventType
import com.example.todolist_.core.model.BaseResourceEvent
import com.example.todolist_.di.IoDispatcher
import com.example.todolist_.local.entity.NoteCardEntity
import com.example.todolist_.onboarding.domain.NoteDataClass
import com.example.todolist_.onboarding.domain.NoteDescriptionDataClass
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

open class BaseRepository @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : IServiceCall by ServiceCall(), IDbCall by DbCall() {
    class ServiceCall : IServiceCall {

    }
    open fun <T : Any, C : Any> callDb(
        call: suspend () -> T,
        mapperCall: (T) -> C
    ): Flow<BaseResourceEvent<C>> {
        return dbCall {
            call()
        }.map {
            it.convertRersourceEventType {
                mapperCall(it.data!!)
            }
        }.flowOn(ioDispatcher)
    }


}
package com.example.todolist_.core.model

import androidx.annotation.StringRes

sealed class BaseResourceEvent<T>(
    val data:T? = null,
    val message:String? = null,
    @StringRes val messageId:Int? = null
) {
    fun <R, C> BaseResourceEvent<R>.convertRersourceEventType(
        convert: () -> C,
    ): BaseResourceEvent<C> {
        return if (this is BaseResourceEvent.Success) {
            BaseResourceEvent.Success(data = convert())
        } else if (this is BaseResourceEvent.Error) {
            BaseResourceEvent.Error(message = this.message)
        } else {
            BaseResourceEvent.Loading()
        }
    }

    class Nothing<T> :BaseResourceEvent<T>()
    class Success<T>(data: T) : BaseResourceEvent<T>(data)
    class Error<T>(message: String?, data: T? = null, messageId: Int? = null) : BaseResourceEvent<T>(data, message,messageId)
    class Loading<T> : BaseResourceEvent<T>()
}


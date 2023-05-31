package com.example.todolist_.core.ext

import com.example.todolist_.core.model.BaseResourceEvent


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
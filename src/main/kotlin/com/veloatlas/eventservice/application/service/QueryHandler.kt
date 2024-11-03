package com.veloatlas.eventservice.application.service

import com.volkswagenag.recall2.shared.application.service.QueryResponse
import java.lang.reflect.ParameterizedType

abstract class QueryHandler<T : Query<R>, R> {

    val genericTypeName: String =
        (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0].typeName

    abstract fun doExecute(query: T): QueryResponse<R>

    fun execute(query: T): QueryResponse<R> {
        return doExecute(query)

    }
}

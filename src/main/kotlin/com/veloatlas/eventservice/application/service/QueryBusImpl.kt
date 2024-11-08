package com.veloatlas.eventservice.application.service

import com.veloatlas.eventservice.application.exception.mapper.DomainToApplicationExceptionCatcher
import com.veloatlas.eventservice.domain.exception.HandlerNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class QueryBusImpl(val queryHandlers: List<QueryHandler<*, *>>) : QueryBus {

    private val logger = LoggerFactory.getLogger(QueryBusImpl::class.java)

    @Suppress("UNCHECKED_CAST", "all")
    @DomainToApplicationExceptionCatcher
    override fun <T> handle(query: Query<T>): QueryResponse<T> {
        val handler = getHandlerForQuery(query)
        return handler.execute(query) as QueryResponse<T>
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> getHandlerForQuery(query: Query<T>): QueryHandler<Query<*>, *> {
        val queryHandler = queryHandlers.firstOrNull {
            it.genericTypeName == query.javaClass.typeName
        } as QueryHandler<Query<*>, *>?
        queryHandler ?: throw HandlerNotFoundException(
            mapOf(Pair("queryName", "$query")),
            "No query handler found for query:$query"
        )

        return queryHandler
    }
}

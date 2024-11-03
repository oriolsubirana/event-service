package com.veloatlas.eventservice.application.service

import com.volkswagenag.recall2.shared.application.service.QueryResponse

interface QueryBus {
    fun <T> handle(query: Query<T>): QueryResponse<T>
}

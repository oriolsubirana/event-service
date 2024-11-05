package com.veloatlas.eventservice.application.service

interface QueryBus {
    fun <T> handle(query: Query<T>): QueryResponse<T>
}

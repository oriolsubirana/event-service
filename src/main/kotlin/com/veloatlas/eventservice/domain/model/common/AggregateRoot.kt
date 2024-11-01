package com.veloatlas.eventservice.domain.model.common

import java.time.LocalDateTime
import java.util.Collections

abstract class AggregateRoot {
    private var domainEvents: MutableList<DomainEvent<*>>? = null
    private val createdAt = LocalDateTime.now()
    private var updatedAt = LocalDateTime.now()

    protected fun recordEvent(domainEvent: DomainEvent<*>) {
        if (domainEvents == null) {
            domainEvents = ArrayList()
        }
        domainEvents!!.add(domainEvent)
        updateIt()
    }

    fun pullEvents(): List<DomainEvent<*>> {
        val domainEventsRecorded = domainEvents
        domainEvents = null
        return Collections.unmodifiableList(domainEventsRecorded ?: listOf())
    }

    fun createdAt(): LocalDateTime {
        return createdAt
    }

    fun updatedAt(): LocalDateTime {
        return updatedAt
    }

    abstract fun id(): Id

    private fun updateIt() {
        updatedAt = LocalDateTime.now()
    }
}

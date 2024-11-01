package com.veloatlas.eventservice.domain.model.common

import java.io.Serializable
import java.time.LocalDateTime

abstract class DomainEvent<D : DomainEventData>(
    val affectedId: String,
    val aggregateType: String,
) : Serializable {
    val id = Id.generate()
    open val shouldBeStored = true
    val happenedOn: LocalDateTime = LocalDateTime.now()
    lateinit var eventData: D

    fun eventSourceName(): String {
        return this::class.java.simpleName
    }

}

abstract class DomainEventData
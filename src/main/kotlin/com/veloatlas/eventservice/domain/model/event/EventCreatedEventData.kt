package com.veloatlas.eventservice.domain.model.event

import com.veloatlas.eventservice.domain.model.common.DomainEventData
import java.time.LocalDateTime

data class EventCreatedEventData(
    val name: String,
    val description: String,
    val date: LocalDateTime
) : DomainEventData()
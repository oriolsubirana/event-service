package com.veloatlas.eventservice.domain.service

import com.veloatlas.eventservice.annotation.DomainService
import com.veloatlas.eventservice.domain.model.Event
import com.veloatlas.eventservice.domain.model.common.Id
import com.veloatlas.eventservice.domain.port.EventRepository

@DomainService
class CommandEventService(private val eventRepository: EventRepository) {

    fun create(event: Event): Id {
        return eventRepository.create(event)
    }
}
package com.veloatlas.eventservice.infrastructure.persistence.jpa

import com.veloatlas.eventservice.domain.model.Event
import com.veloatlas.eventservice.domain.model.common.Id
import com.veloatlas.eventservice.domain.port.EventRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class EventJpaRepositoryAdapter(
    private val eventJpaRepository: EventJpaRepository,
    private val eventJpaRepositoryMapper: EventJpaRepositoryMapper
) : EventRepository {

    private var log = LoggerFactory.getLogger(EventJpaRepositoryAdapter::class.java)

    override fun create(event: Event): Id {
        val eventJpa = eventJpaRepositoryMapper.toEventJpaEntity(event)
        val newEvent = eventJpaRepository.save(eventJpa)
        log.info("Created new Event with id:${newEvent.id} and ${eventJpa.id}")
        return Id.fromString(newEvent.id.toString())
    }
}
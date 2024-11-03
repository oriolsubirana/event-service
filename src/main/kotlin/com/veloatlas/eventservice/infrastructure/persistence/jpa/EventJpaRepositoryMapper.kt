package com.veloatlas.eventservice.infrastructure.persistence.jpa

import com.veloatlas.eventservice.domain.model.Event
import com.veloatlas.eventservice.domain.model.EventType
import com.veloatlas.eventservice.domain.model.Location
import com.veloatlas.eventservice.domain.model.common.Id
import com.veloatlas.eventservice.domain.port.OrganizerRepository
import org.springframework.stereotype.Component

@Component
class EventJpaRepositoryMapper(
    private val organizerRepository: OrganizerRepository
) {

    fun toEvent(eventJpaEntity: EventJpaEntity): Event = Event(
        id = Id.fromString(eventJpaEntity.id.toString()),
        name = eventJpaEntity.name!!,
        location = Location(
            latitude = eventJpaEntity.latitude!!,
            longitude = eventJpaEntity.longitude!!
        ),
        date = eventJpaEntity.date!!,
        description = eventJpaEntity.description!!,
        imageUrl = eventJpaEntity.imageUrl!!,
        eventLink = eventJpaEntity.eventLink!!,
        country = eventJpaEntity.country!!,
        type = EventType.valueOf(eventJpaEntity.type!!),
        organizer = organizerRepository.find(Id.fromString(eventJpaEntity.organizer!!.toString()))
    )

    fun toEventJpaEntity(event: Event): EventJpaEntity = EventJpaEntity(
        id = event.id().toUUID(),
        name = event.name(),
        latitude = event.location().latitude,
        longitude = event.location().longitude,
        date = event.date(),
        description = event.description(),
        imageUrl = event.imageUrl(),
        eventLink = event.eventLink(),
        country = event.country(),
        type = event.type().name,
        organizer = event.organizer().id.toUUID()
    )
}
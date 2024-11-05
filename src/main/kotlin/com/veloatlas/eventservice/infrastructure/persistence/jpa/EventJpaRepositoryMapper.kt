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
        organizer = organizerRepository.find(Id.fromString(eventJpaEntity.organizer!!.toString())),
        lastSaved = eventJpaEntity.lastSaved!!,
        createdDate = eventJpaEntity.createdDate!!
    )

    fun toEventJpaEntity(event: Event): EventJpaEntity = EventJpaEntity(
        id = event.id().toUUID(),
        name = event.name(),
        description = event.description(),
        date = event.date(),
        country = event.country(),
        latitude = event.location().latitude,
        longitude = event.location().longitude,
        type = event.type().name,
        organizer = OrganizerJpaEntity(
            id = event.organizer().id().toUUID(),
            name = event.organizer().name,
            address = event.organizer().address,
            zip = event.organizer().zip,
            city = event.organizer().city,
            country = event.organizer().country,
            email = event.organizer().email,
            phone = event.organizer().phone,
            createdDate = event.organizer().createdDate,
            lastSaved = event.organizer().lastSaved
        ),
        eventLink = event.eventLink(),
        imageUrl = event.imageUrl(),
        createdDate = event.createdDate(),
        lastSaved = event.lastSaved()
    )
}
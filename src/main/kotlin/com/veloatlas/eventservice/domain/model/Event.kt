package com.veloatlas.eventservice.domain.model

import com.veloatlas.eventservice.domain.model.common.AggregateRoot
import com.veloatlas.eventservice.domain.model.common.Id
import com.veloatlas.eventservice.domain.model.event.EventCreatedEvent
import java.time.LocalDateTime
import java.time.OffsetDateTime

class Event(
    val id: Id,
    private var name: String,
    private var description: String,
    private var date: LocalDateTime,
    private var country: String,
    private var location: Location,
    private var type: EventType,
    private var organizer: Organizer,
    private var eventLink: String,
    private var imageUrl: String,
    private var lastSaved: OffsetDateTime,
    private var createdDate: OffsetDateTime,
) : AggregateRoot() {

    companion object {
        fun create(
            id: Id,
            name: String,
            description: String,
            date: LocalDateTime,
            country: String,
            location: Location,
            type: EventType,
            organizer: Organizer,
            eventLink: String,
            imageUrl: String
        ): Event {
            return run {
                Event(
                    id,
                    name,
                    description,
                    date,
                    country,
                    location,
                    type,
                    organizer,
                    eventLink,
                    imageUrl,
                    lastSaved = OffsetDateTime.now(),
                    createdDate = OffsetDateTime.now(),
                )
            }.also {
                it.recordEvent(
                    EventCreatedEvent(
                        event = it
                    )
                )
            }
        }
    }

    override fun id(): Id {
        return id
    }

    fun name(): String {
        return name
    }

    fun description(): String {
        return description
    }

    fun date(): LocalDateTime {
        return date
    }

    fun country(): String {
        return country
    }

    fun location(): Location {
        return location
    }

    fun type(): EventType {
        return type
    }

    fun organizer(): Organizer {
        return organizer
    }

    fun eventLink(): String {
        return eventLink
    }

    fun imageUrl(): String {
        return imageUrl
    }

    fun createdDate(): OffsetDateTime {
        return createdDate
    }

    fun lastSaved(): OffsetDateTime {
        return lastSaved
    }
}
package com.veloatlas.eventservice.domain.model.event

import com.veloatlas.eventservice.domain.model.Event
import com.veloatlas.eventservice.domain.model.common.DomainEvent

class EventCreatedEvent(val event: Event) : DomainEvent<EventCreatedEventData>(
    affectedId = event.id().toString(),
    aggregateType = Event::class.simpleName!!
) {
    init {
        eventData = EventCreatedEventData(
            name = event.name(),
            description = event.description(),
            date = event.date()
        )
    }
}

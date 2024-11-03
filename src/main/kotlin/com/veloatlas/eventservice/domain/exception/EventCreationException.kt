package com.veloatlas.eventservice.domain.exception

import com.veloatlas.eventservice.domain.model.common.Id

class EventCreationException(id: Id, cause: Throwable) :
    InternalErrorException(
        mapOf(
            Pair("eventId", id.toString()),
        ),
        "Event not created for ID: $id", cause
    ) {
    override fun i18nKey() = "events.error.event.creationError"
}
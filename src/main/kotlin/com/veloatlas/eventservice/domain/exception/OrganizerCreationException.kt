package com.veloatlas.eventservice.domain.exception

import com.veloatlas.eventservice.domain.model.common.Id

class OrganizerCreationException(id: Id, cause: Throwable) :
    InternalErrorException(
        mapOf(
            Pair("organizerId", id.toString()),
        ),
        "Organizer not created for ID: $id", cause
    ) {
    override fun i18nKey() = "events.error.organizer.creationError"
}
package com.veloatlas.eventservice.domain.exception

import com.veloatlas.eventservice.domain.model.common.Id

class OrganizerNotFoundException : NotFoundException {
    constructor(id: Id) : super(
        mapOf(
            Pair("organizerId", id.toString())
        ), "Organizer not found for ID $id"
    )

    constructor(id: Id, cause: Throwable) : super(
        mapOf(
            Pair("organizerId", id.toString())
        ), "Organizer not found for ID $id", cause
    )

    constructor() : super(
        mapOf(), "Organizer not found"
    )

    override fun i18nKey() = "veloatlas.error.organizer.notFound"
}


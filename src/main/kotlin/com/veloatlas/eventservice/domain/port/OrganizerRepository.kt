package com.veloatlas.eventservice.domain.port

import com.veloatlas.eventservice.domain.model.Organizer
import com.veloatlas.eventservice.domain.model.common.Id

interface OrganizerRepository {
    fun find(id: Id): Organizer
}
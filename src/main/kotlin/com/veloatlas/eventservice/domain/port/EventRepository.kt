package com.veloatlas.eventservice.domain.port

import com.veloatlas.eventservice.domain.model.Event
import com.veloatlas.eventservice.domain.model.common.Id

interface EventRepository {
    fun create(event: Event): Id
}
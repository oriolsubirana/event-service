package com.veloatlas.eventservice.application.mapper

import com.veloatlas.eventservice.application.dto.EventDto
import com.veloatlas.eventservice.domain.model.common.Id
import org.springframework.stereotype.Service

@Service
class EventMapper {

    fun toEventDto(id: Id): EventDto {
        return EventDto(
            id = id.toString(),
        )
    }
}
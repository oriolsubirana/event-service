package com.veloatlas.eventservice.application.mapper

import com.veloatlas.eventservice.application.dto.OrganizerDto
import com.veloatlas.eventservice.domain.model.common.Id
import org.springframework.stereotype.Service

@Service
class OrganizerMapper {

    fun toOrganizerDto(id: Id): OrganizerDto {
        return OrganizerDto(
            id = id.toString(),
        )
    }
}
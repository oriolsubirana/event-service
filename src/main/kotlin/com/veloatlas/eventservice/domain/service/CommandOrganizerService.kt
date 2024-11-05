package com.veloatlas.eventservice.domain.service

import com.veloatlas.eventservice.annotation.DomainService
import com.veloatlas.eventservice.domain.model.Organizer
import com.veloatlas.eventservice.domain.model.common.Id
import com.veloatlas.eventservice.domain.port.OrganizerRepository

@DomainService
class CommandOrganizerService(private val organizerRepository: OrganizerRepository) {

    fun create(event: Organizer): Id {
        return organizerRepository.create(event)
    }
}
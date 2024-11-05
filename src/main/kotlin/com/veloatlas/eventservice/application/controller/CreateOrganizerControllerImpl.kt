package com.veloatlas.eventservice.application.controller

import com.veloatlas.eventservice.api.v1.controller.CreateOrganizerController
import com.veloatlas.eventservice.api.v1.dto.CreateOrganizerRequest
import com.veloatlas.eventservice.api.v1.dto.CreateOrganizerResponse
import com.veloatlas.eventservice.application.command.CreateOrganizerCommand
import com.veloatlas.eventservice.application.dto.OrganizerDto
import com.veloatlas.eventservice.application.controller.mapper.toRestResponse
import com.veloatlas.eventservice.application.service.CommandBus
import com.veloatlas.eventservice.application.service.CommandResponse
import org.slf4j.LoggerFactory.getLogger
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateOrganizerControllerImpl(
    private val commandBus: CommandBus
) : CreateOrganizerController {

    private var log = getLogger(CreateOrganizerControllerImpl::class.java)

    override fun createOrganizer(@RequestBody createOrganizerRequest: CreateOrganizerRequest): CreateOrganizerResponse {
        log.info("Starting process for creating organizer with name ${createOrganizerRequest.name}")
        return commandBus.handle(
            createOrganizerRequest.createCommandFromRequest()
        ).createResponseFromCommandResponse()
    }

    fun CreateOrganizerRequest.createCommandFromRequest() = CreateOrganizerCommand(
        name = this.name,
        address = this.address,
        zip = this.zip,
        city = this.city,
        country = this.country,
        email = this.email,
        phone = this.phone
    )

    fun CommandResponse.createResponseFromCommandResponse(): CreateOrganizerResponse {
        val response = this.response as OrganizerDto
        return response.toRestResponse()
    }
}
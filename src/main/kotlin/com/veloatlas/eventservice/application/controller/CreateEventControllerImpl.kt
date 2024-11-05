package com.veloatlas.eventservice.application.controller

import com.veloatlas.eventservice.api.v1.controller.CreateEventController
import com.veloatlas.eventservice.api.v1.dto.CreateEventRequest
import com.veloatlas.eventservice.api.v1.dto.CreateEventResponse
import com.veloatlas.eventservice.application.command.CreateEventCommand
import com.veloatlas.eventservice.application.controller.mapper.toRestResponse
import com.veloatlas.eventservice.application.dto.EventDto
import com.veloatlas.eventservice.application.service.CommandBus
import com.veloatlas.eventservice.application.service.CommandResponse
import org.slf4j.LoggerFactory.getLogger
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateEventControllerImpl(
    private val commandBus: CommandBus
) : CreateEventController {

    private var log = getLogger(CreateEventControllerImpl::class.java)

    override fun createEvent(@RequestBody createEventRequest: CreateEventRequest): CreateEventResponse {
        log.info("Starting process for creating event with name: ${createEventRequest.name}")
        return commandBus.handle(
            createEventRequest.createCommandFromRequest()
        ).createResponseFromCommandResponse()
    }

    fun CreateEventRequest.createCommandFromRequest() = CreateEventCommand(
        name = this.name,
        description = this.description!!,
        date = this.date,
        country = this.country,
        longitude = this.longitude,
        latitude = this.latitude,
        type = this.type,
        organizerId = this.organizerId,
        eventLink = this.eventLink,
        imageUrl = this.imageUrl,
    )

    fun CommandResponse.createResponseFromCommandResponse(): CreateEventResponse {
        val response = this.response as EventDto
        return response.toRestResponse()
    }
}
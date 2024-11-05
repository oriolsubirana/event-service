package com.veloatlas.eventservice.application.command

import com.veloatlas.eventservice.annotation.VeloAtlasCommandHandler
import com.veloatlas.eventservice.application.mapper.EventMapper
import com.veloatlas.eventservice.application.service.CommandHandler
import com.veloatlas.eventservice.application.service.CommandResponse
import com.veloatlas.eventservice.domain.exception.EventCreationException
import com.veloatlas.eventservice.domain.model.Event
import com.veloatlas.eventservice.domain.model.EventType
import com.veloatlas.eventservice.domain.model.Location
import com.veloatlas.eventservice.domain.model.common.Id
import com.veloatlas.eventservice.domain.port.OrganizerRepository
import com.veloatlas.eventservice.domain.service.CommandEventService

@VeloAtlasCommandHandler
class CreateEventCommandHandler(
    private val createCommandEventService: CommandEventService,
    private val organizerRepository: OrganizerRepository,
    private val eventMapper: EventMapper
) : CommandHandler<CreateEventCommand>() {

    override fun doExecute(command: CreateEventCommand): CommandResponse {
        var id = Id.generate()

        val event = Event.create(
            id = id,
            name = command.name,
            description = command.description,
            date = command.date,
            country = command.country,
            location = Location(command.longitude.toDouble(), command.latitude.toDouble()),
            type = EventType.valueOf(command.type),
            organizer = organizerRepository.find(Id.fromString(command.organizerId)),
            eventLink = command.eventLink,
            imageUrl = command.imageUrl
        )

        try {
            id = createCommandEventService.create(event)
        } catch (ex: Exception) {
            throw EventCreationException(id, ex)
        }
        return CommandResponse.successResponse(eventMapper.toEventDto(id))
    }
}
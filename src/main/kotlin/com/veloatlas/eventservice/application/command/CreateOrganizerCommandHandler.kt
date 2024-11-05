package com.veloatlas.eventservice.application.command

import com.veloatlas.eventservice.annotation.VeloAtlasCommandHandler
import com.veloatlas.eventservice.application.mapper.OrganizerMapper
import com.veloatlas.eventservice.application.service.CommandHandler
import com.veloatlas.eventservice.application.service.CommandResponse
import com.veloatlas.eventservice.domain.exception.OrganizerCreationException
import com.veloatlas.eventservice.domain.model.Organizer
import com.veloatlas.eventservice.domain.model.common.Id
import com.veloatlas.eventservice.domain.service.CommandOrganizerService
import java.time.OffsetDateTime

@VeloAtlasCommandHandler
class CreateOrganizerCommandHandler(
    private val createCommandOrganizerService: CommandOrganizerService,
    private val organizerMapper: OrganizerMapper,
) : CommandHandler<CreateOrganizerCommand>() {

    override fun doExecute(command: CreateOrganizerCommand): CommandResponse {
        var id = Id.generate()

        val event = Organizer(
            id = id,
            name = command.name,
            address = command.address,
            zip = command.zip,
            city = command.city,
            country = command.country,
            email = command.email,
            phone = command.phone,
            lastSaved = OffsetDateTime.now(),
            createdDate = OffsetDateTime.now(),
        )

        try {
            id = createCommandOrganizerService.create(event)
        } catch (ex: Exception) {
            throw OrganizerCreationException(id, ex)
        }
        return CommandResponse.successResponse(organizerMapper.toOrganizerDto(id))
    }
}
package com.veloatlas.eventservice.api.v1.controller

import com.veloatlas.eventservice.api.v1.dto.CreateOrganizerRequest
import com.veloatlas.eventservice.api.v1.dto.CreateOrganizerResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus

@Validated
@Tag(
    description = "Create Organizer Controller",
    name = "Organizer"
)
interface CreateOrganizerController {

    @PostMapping(path = ["v1/organizer"])
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Create new organizer")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201", description = "Organizer successfully created response"
            )
        ]
    )
    fun createOrganizer(
        @Parameter(description = "The new organizer details to be saved")
        @RequestBody createOrganizerRequest: CreateOrganizerRequest
    ): CreateOrganizerResponse
}
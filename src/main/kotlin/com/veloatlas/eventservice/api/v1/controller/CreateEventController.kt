package com.veloatlas.eventservice.api.v1.controller

import com.veloatlas.eventservice.api.v1.dto.CreateEventRequest
import com.veloatlas.eventservice.api.v1.dto.CreateEventResponse
import com.veloatlas.eventservice.domain.model.common.Id
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
    description = "Create Event Controller",
    name = "Event"
)
interface CreateEventController {

    @PostMapping(path = ["v1/events"])
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Create new event")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201", description = "Event successfully created response"
            )
        ]
    )
    fun createEvent(
        @Parameter(description = "The new event details to be saved")
        @RequestBody createEventRequest: CreateEventRequest
    ): CreateEventResponse
}
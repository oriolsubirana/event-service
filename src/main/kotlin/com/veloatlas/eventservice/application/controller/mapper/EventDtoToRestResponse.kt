package com.veloatlas.eventservice.application.controller.mapper

import com.veloatlas.eventservice.api.v1.dto.CreateEventResponse
import com.veloatlas.eventservice.application.dto.EventDto

fun EventDto.toRestResponse() = CreateEventResponse(
    id = this.id
)
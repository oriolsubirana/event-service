package com.veloatlas.eventservice.application.controller.mapper

import com.veloatlas.eventservice.api.v1.dto.CreateEventResponse

fun CreateEventResponse.toRestResponse() = CreateEventResponse(
    id = this.id
)
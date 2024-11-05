package com.veloatlas.eventservice.application.controller.mapper

import com.veloatlas.eventservice.api.v1.dto.CreateOrganizerResponse
import com.veloatlas.eventservice.application.dto.OrganizerDto

fun OrganizerDto.toRestResponse() = CreateOrganizerResponse(
    id = this.id
)
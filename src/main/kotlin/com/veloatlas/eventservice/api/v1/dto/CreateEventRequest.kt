package com.veloatlas.eventservice.api.v1.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(
    name = "CreateEventRequest",
    description = "Create new event request"
)
data class CreateEventRequest(
    @Schema(name = "name", required = true, example = "event name")
    val name: String,

    @Schema(name = "description", required = false, example = "event description")
    val description: String?,

    @Schema(name = "location", required = true, example = "event location")
    val location: String,

    @Schema(name = "date", required = true, example = "2021-12-31T23:59:59")
    val date: LocalDateTime,

    @Schema(
        name = "organizer id",
        required = true,
        example = "8846b102-f9d5-6c25-9815-65321d2c8df4"
    )
    val organizerId: String,

    @Schema(name = "country", required = true, example = "event country")
    val country: String,

    @Schema(name = "longitude", required = true, example = "event longitude")
    val longitude: String,

    @Schema(name = "latitude", required = true, example = "event latitude")
    val latitude: String,

    @Schema(name = "type", required = true, example = "event type")
    val type: String,

    @Schema(name = "event link", required = false, example = "event link")
    val eventLink: String,

    @Schema(name = "image url", required = false, example = "event image url")
    val imageUrl: String,
)
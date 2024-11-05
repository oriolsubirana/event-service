package com.veloatlas.eventservice.api.v1.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(
    name = "CreateOrganizerRequest",
    description = "Create new organizer request"
)
data class CreateOrganizerRequest(

    @Schema(name = "name", required = true, example = "organizer name")
    val name: String,

    @Schema(name = "address", required = true, example = "organizer address")
    val address: String,

    @Schema(name = "zip", required = true, example = "organizer zip")
    val zip: String,

    @Schema(name = "city", required = true, example = "organizer city")
    val city: String,

    @Schema(name = "country", required = true, example = "organizer country")
    val country: String,

    @Schema(name = "email", required = true, example = "organizer email")
    val email: String,

    @Schema(name = "phone", required = true, example = "organizer phone")
    val phone: String
)
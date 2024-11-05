package com.veloatlas.eventservice.application.command

import com.veloatlas.eventservice.application.service.Command

class CreateOrganizerCommand(
    val name: String,
    val address: String,
    val zip: String,
    val city: String,
    val country: String,
    val email: String,
    val phone: String
) : Command
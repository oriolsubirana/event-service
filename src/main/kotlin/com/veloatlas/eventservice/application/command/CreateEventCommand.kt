package com.veloatlas.eventservice.application.command

import com.veloatlas.eventservice.application.service.Command
import java.time.LocalDateTime

class CreateEventCommand(
    val name: String,
    val description: String,
    val date: LocalDateTime,
    val country: String,
    val longitude: String,
    val latitude: String,
    val type: String,
    val organizerId: String,
    val eventLink: String,
    val imageUrl: String,
) : Command
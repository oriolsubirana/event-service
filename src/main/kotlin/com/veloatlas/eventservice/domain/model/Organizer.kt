package com.veloatlas.eventservice.domain.model

import com.veloatlas.eventservice.domain.model.common.Id

class Organizer(
    val id: Id,
    private val name: String,
    private val address: String,
    private val zip: String,
    private val city: String,
    private val country: String,
    private val email: String,
    private val phone: String
)
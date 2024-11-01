package com.veloatlas.eventservice.domain.model

import com.veloatlas.eventservice.domain.model.common.Id

class Organizer(
    private val id: Id,
    private val name: String,
    private val email: String,
    private val phone: String
)
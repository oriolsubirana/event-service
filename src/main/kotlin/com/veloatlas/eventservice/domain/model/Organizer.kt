package com.veloatlas.eventservice.domain.model

import com.veloatlas.eventservice.domain.model.common.AggregateRoot
import com.veloatlas.eventservice.domain.model.common.Id
import java.time.OffsetDateTime

class Organizer(
    val id: Id,
    val name: String,
    val address: String,
    val zip: String,
    val city: String,
    val country: String,
    val email: String,
    val phone: String,
    val lastSaved: OffsetDateTime,
    val createdDate: OffsetDateTime,
) : AggregateRoot() {

    override fun id(): Id {
        return id
    }

    fun name(): String {
        return name
    }

    fun address(): String {
        return address
    }

    fun zip(): String {
        return zip
    }

    fun city(): String {
        return city
    }

    fun country(): String {
        return country
    }

    fun email(): String {
        return email
    }

    fun phone(): String {
        return phone
    }

    fun lastSaved(): OffsetDateTime {
        return lastSaved
    }

    fun createdDate(): OffsetDateTime {
        return createdDate
    }

}
package com.veloatlas.eventservice.infrastructure.persistence.jpa

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "organizer")
open class OrganizerJpaEntity(

    @Id
    open var id: UUID? = null,

    @Column(name = "name", nullable = false)
    open var name: String,

    @Column(name = "address")
    open var address: String? = null,

    @Column(name = "zip", nullable = false)
    open var zip: String? = null,

    @Column(name = "city", nullable = false)
    open var city: String? = null,

    @Column(name = "country", nullable = false)
    open var country: String? = null,

    @Column(name = "email", nullable = false)
    open var email: String? = null,

    @Column(name = "phone", nullable = false)
    open var phone: String? = null
)
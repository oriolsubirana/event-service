package com.veloatlas.eventservice.infrastructure.persistence.jpa

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "events")
open class EventJpaEntity(

    @Id
    open var id: UUID? = null,

    @Column(name = "name", nullable = false)
    open var name: String? = null,

    @Column(name = "description", columnDefinition = "TEXT")
    open var description: String? = null,

    @Column(name = "date", nullable = false)
    open var date: LocalDateTime? = null,

    @Column(name = "country", nullable = false)
    open var country: String? = null,

    @Column(name = "latitude", nullable = false)
    open var latitude: Double? = null,

    @Column(name = "longitude", nullable = false)
    open var longitude: Double? = null,

    @Column(name = "type", nullable = false)
    open var type: String? = null,

    @Column(name = "organizer", nullable = false)
    open var organizer: String? = null,

    @Column(name = "eventLink", nullable = false)
    open var eventLink: String? = null,

    @Column(name = "imageUrl", nullable = false)
    open var imageUrl: String?

) : AbstractJpaAuditableEntity<String>()
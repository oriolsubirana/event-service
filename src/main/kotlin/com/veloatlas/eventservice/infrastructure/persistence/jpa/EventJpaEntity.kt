package com.veloatlas.eventservice.infrastructure.persistence.jpa

import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.util.UUID

@Entity
@Table(name = "event")
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

    @ManyToOne(targetEntity = OrganizerJpaEntity::class)
    @JoinColumn(name = "organizer_id")
    open var organizer: OrganizerJpaEntity? = null,

    @Column(name = "event_link", nullable = false)
    open var eventLink: String? = null,

    @Column(name = "image_url", nullable = false)
    open var imageUrl: String? = null,

    @Column(name = "created_date", nullable = false)
    open var createdDate: OffsetDateTime? = null,

    @Column(name = "last_saved", nullable = false)
    open var lastSaved: OffsetDateTime? = null,
)
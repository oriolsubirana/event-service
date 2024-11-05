package com.veloatlas.eventservice.infrastructure.persistence.jpa

import com.veloatlas.eventservice.domain.model.Organizer
import com.veloatlas.eventservice.domain.model.common.Id
import org.springframework.stereotype.Component

@Component
class OrganizerJpaRepositoryMapper {

    fun toOrganizer(organizerJpaEntity: OrganizerJpaEntity): Organizer = Organizer(
        id = Id.fromString(organizerJpaEntity.id.toString()),
        name = organizerJpaEntity.name!!,
        address = organizerJpaEntity.address!!,
        zip = organizerJpaEntity.zip!!,
        city = organizerJpaEntity.city!!,
        country = organizerJpaEntity.country!!,
        email = organizerJpaEntity.email!!,
        phone = organizerJpaEntity.phone!!,
        lastSaved = organizerJpaEntity.lastSaved!!,
        createdDate = organizerJpaEntity.createdDate!!
    )

    fun toOrganizerJpaEntity(organizer: Organizer): OrganizerJpaEntity = OrganizerJpaEntity(
        id = organizer.id().toUUID(),
        name = organizer.name(),
        address = organizer.address(),
        zip = organizer.zip(),
        city = organizer.city(),
        country = organizer.country(),
        email = organizer.email(),
        phone = organizer.phone(),
        createdDate = organizer.createdDate,
        lastSaved = organizer.lastSaved
    )

}
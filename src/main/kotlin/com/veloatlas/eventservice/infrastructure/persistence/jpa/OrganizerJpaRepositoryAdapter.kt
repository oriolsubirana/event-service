package com.veloatlas.eventservice.infrastructure.persistence.jpa

import com.veloatlas.eventservice.domain.exception.OrganizerNotFoundException
import com.veloatlas.eventservice.domain.model.Organizer
import com.veloatlas.eventservice.domain.model.common.Id
import com.veloatlas.eventservice.domain.port.OrganizerRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class OrganizerJpaRepositoryAdapter(
    private val organizerJpaRepository: OrganizerJpaRepository,
    private val organizerJpaRepositoryMapper: OrganizerJpaRepositoryMapper
) : OrganizerRepository {

    private var log = LoggerFactory.getLogger(OrganizerJpaRepositoryAdapter::class.java)

    override fun find(id: Id): Organizer {
        val organizerJpaEntity = findOrganizer(id)
        return organizerJpaRepositoryMapper.toOrganizer(organizerJpaEntity)
    }

    override fun create(organizer: Organizer): Id {
        val organizerJpa = organizerJpaRepositoryMapper.toOrganizerJpaEntity(organizer)
        val newOrganizer = organizerJpaRepository.save(organizerJpa)
        log.info("Created new Organizer with id: ${newOrganizer.id}")
        return Id.fromString(newOrganizer.id.toString())
    }

    @Throws(OrganizerNotFoundException::class)
    private fun findOrganizer(id: Id): OrganizerJpaEntity {
        return organizerJpaRepository.findById(id.toUUID())
            .orElseThrow { throw OrganizerNotFoundException(id) }
    }


}
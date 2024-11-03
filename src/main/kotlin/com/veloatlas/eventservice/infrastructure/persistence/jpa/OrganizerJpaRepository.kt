package com.veloatlas.eventservice.infrastructure.persistence.jpa

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrganizerJpaRepository : CrudRepository<OrganizerJpaEntity, UUID>
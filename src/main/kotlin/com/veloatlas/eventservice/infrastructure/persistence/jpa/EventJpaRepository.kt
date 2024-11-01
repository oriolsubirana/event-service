package com.veloatlas.eventservice.infrastructure.persistence.jpa

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface EventJpaRepository : PagingAndSortingRepository<EventJpaEntity, UUID> {
}
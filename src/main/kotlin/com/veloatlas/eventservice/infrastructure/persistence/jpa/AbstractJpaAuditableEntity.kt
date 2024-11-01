package com.veloatlas.eventservice.infrastructure.persistence.jpa

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.Instant

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AbstractJpaAuditableEntity<U : Serializable> : AbstractJpaPersistableEntity() {

    @CreatedBy
    @Column(name = "row_created_by", updatable = false, nullable = false)
    open lateinit var createdBy: U

    @CreatedDate
    @Column(name = "row_created_on", updatable = false, nullable = false)
    open var createdDate: Instant? = null

    @LastModifiedDate
    @Column(name = "row_updated_on", updatable = true, nullable = true)
    open lateinit var lastModifiedDate: Instant

    @LastModifiedBy
    @Column(name = "row_updated_by", updatable = true, nullable = true)
    open lateinit var lastModifiedBy: U

}

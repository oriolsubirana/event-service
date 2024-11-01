package com.veloatlas.eventservice.infrastructure.persistence.jpa

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Version


/**
 * Abstract entity class that defines the JPA entity id field type and versioning
 * which is used in optimistic locking. Optimistic locking is when you check if the record
 * was updated by someone else before you commit the transaction.
 *
 * @param <ID>
</ID> */
@MappedSuperclass
abstract class AbstractJpaPersistableEntity {

    @Version
    @Column(name = "row_version")
    open var version: Long? = null

    override fun toString() = "Jpa Entity of type ${this.javaClass.name}"
}
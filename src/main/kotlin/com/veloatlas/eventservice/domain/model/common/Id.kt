package com.veloatlas.eventservice.domain.model.common

import com.veloatlas.eventservice.domain.exception.InvalidArgument
import com.veloatlas.eventservice.domain.exception.InvalidIdArgumentException
import java.util.UUID

open class Id private constructor(id: String?) {
    private val id: String

    init {
        validate(id)
        this.id = id ?: UUID.randomUUID().toString()
    }

    fun id() = id

    private fun validate(id: String?) {
        try {
            if (!id.isNullOrEmpty()) {
                UUID.fromString(id)
            }
        } catch (e: IllegalArgumentException) {
            throw InvalidIdArgumentException(
                mapOf(Pair("id", "UUID")), "Invalid UUID provided",
                e,
                arrayOf(InvalidArgument("uuid", "common.error.id.invalid"))
            )
        }
    }

    override fun toString(): String {
        return id
    }

    fun toUUID(): UUID {
        return UUID.fromString(id)
    }

    override fun equals(other: Any?): Boolean = (other is Id && id == other.toString())

    override fun hashCode(): Int = id.hashCode()


    companion object {
        fun fromString(id: String): Id {
            return Id(id)
        }

        fun generate(): Id {
            return Id(null)
        }
    }
}
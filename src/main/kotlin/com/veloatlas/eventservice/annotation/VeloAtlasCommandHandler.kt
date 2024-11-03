package com.veloatlas.eventservice.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

/**
 * Annotation for application command handler classes which
 * alias for the `@Component` and it will add `@Transactional`
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Transactional(transactionManager = "transactionManager")
@Component
annotation class VeloAtlasCommandHandler(
    @get: AliasFor(annotation = Component::class)
    val value: String = ""
)


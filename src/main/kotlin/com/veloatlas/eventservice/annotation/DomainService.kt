package com.veloatlas.eventservice.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Service

/**
 * Annotation for domain specific service classes which is an
 * alias for the `@Service`
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Service
annotation class DomainService(
    @get: AliasFor(annotation = Service::class)
    val value: String = ""
)


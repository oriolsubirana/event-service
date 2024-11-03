package com.veloatlas.eventservice.annotation

import org.springframework.context.event.EventListener

/**
 * Recall alternative for using the spring `@EventListener`
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@EventListener
annotation class VeloAtlasEventListener


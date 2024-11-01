package com.veloatlas.eventservice.domain.exception

abstract class BaseDomainException : RuntimeException {

    private var i18nMessageParams: Map<String, String>? = emptyMap()

    constructor(i18nMessageParams: Map<String, String>, message: String, cause: Throwable) : super(
        message,
        cause
    ) {
        this.i18nMessageParams = i18nMessageParams
    }

    constructor(i18nMessageParams: Map<String, String>, message: String) : super(message) {
        this.i18nMessageParams = i18nMessageParams
    }

    abstract fun i18nKey(): String
}
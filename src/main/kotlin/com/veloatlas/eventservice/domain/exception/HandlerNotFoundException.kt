package com.veloatlas.eventservice.domain.exception

class HandlerNotFoundException : InternalErrorException {
    constructor(
        i18nMessageParams: Map<String, String>,
        message: String,
        cause: Throwable
    ) : super(i18nMessageParams, message, cause)

    constructor(i18nMessageParams: Map<String, String>, message: String) : super(
        i18nMessageParams,
        message
    )

    override fun i18nKey() = "veloatlas.error.handler.notFound"
}
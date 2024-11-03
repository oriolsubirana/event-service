package com.veloatlas.eventservice.domain.exception

abstract class InternalErrorException : BaseDomainException {
    constructor(
        i18nMessageParams: Map<String, String>,
        message: String,
        cause: Throwable
    ) : super(i18nMessageParams, message, cause)

    constructor(i18nMessageParams: Map<String, String>, message: String) : super(
        i18nMessageParams,
        message
    )


}

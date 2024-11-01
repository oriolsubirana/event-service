package com.veloatlas.eventservice.domain.exception

class InvalidIdArgumentException : InvalidArgumentException {
    constructor(
        i18nMessageParams: Map<String, String>,
        message: String,
        cause: Throwable,
        invalidArguments: Array<InvalidArgument>?
    ) : super(i18nMessageParams, message, cause, invalidArguments)

    constructor(
        i18nMessageParams: Map<String, String>,
        message: String,
        invalidArguments: Array<InvalidArgument>?
    ) : super(i18nMessageParams, message, invalidArguments)


    override fun i18nKey() = "common.error.id.invalid"
}
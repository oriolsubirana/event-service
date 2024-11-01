package com.veloatlas.eventservice.domain.exception

abstract class InvalidArgumentException : BaseDomainException {

    private var invalidArguments:Array<InvalidArgument>? = emptyArray()

    constructor(
        i18nMessageParams : Map<String,String>,
        message: String,
        cause: Throwable,
        invalidArguments: Array<InvalidArgument>?
    ) : super(i18nMessageParams, message, cause) {
        this.invalidArguments = invalidArguments
    }

    constructor(
        i18nMessageParams : Map<String,String>,
        message: String,
        invalidArguments: Array<InvalidArgument>?
    ) : super(i18nMessageParams, message) {
        this.invalidArguments = invalidArguments
    }

    fun invalidArguments() = invalidArguments

}

data class InvalidArgument(
    val field:String,
    val message:String
)

package com.veloatlas.eventservice.application.service

class CommandResponse private constructor(
    val success: Boolean,
    val response: Any?
) {
    private var message: String? = null

    companion object {
        fun successResponse(response: Any?): CommandResponse {
            return CommandResponse(true, response)
        }

        fun failedResponse(response: Any?): CommandResponse {
            return CommandResponse(false, response)
        }
    }

    fun withMessage(message: String): CommandResponse {
        this.message = message
        return this
    }

    fun message(): String? {
        return message
    }
}

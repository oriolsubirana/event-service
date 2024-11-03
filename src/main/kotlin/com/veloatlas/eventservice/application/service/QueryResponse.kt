package com.veloatlas.eventservice.application.service

class QueryResponse<Response> private constructor(
    val success: Boolean,
    val response: Response
) {
    private var message: String? = null

    companion object {
        fun <Response> successResponse(response: Response): QueryResponse<Response> {
            return QueryResponse(true, response)
        }

        fun <Response> failedResponse(response: Response): QueryResponse<Response> {
            return QueryResponse(false, response)
        }
    }

    fun withMessage(message: String): QueryResponse<Response> {
        this.message = message
        return this
    }

    fun message(): String? {
        return message
    }
}

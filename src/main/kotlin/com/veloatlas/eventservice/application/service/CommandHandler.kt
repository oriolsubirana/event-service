package com.veloatlas.eventservice.application.service

import com.volkswagenag.recall2.shared.application.service.CommandResponse

abstract class CommandHandler<Command> {

    abstract fun doExecute(command: Command): CommandResponse

    fun execute(command: Command): CommandResponse {
        return doExecute(command)
    }
}

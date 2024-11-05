package com.veloatlas.eventservice.application.service

abstract class CommandHandler<Command> {

    abstract fun doExecute(command: Command): CommandResponse

    fun execute(command: Command): CommandResponse {
        return doExecute(command)
    }
}

package com.veloatlas.eventservice.application.service

interface CommandBus {
    fun handle(command: Command): CommandResponse
}

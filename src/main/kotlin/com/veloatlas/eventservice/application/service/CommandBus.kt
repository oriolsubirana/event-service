package com.veloatlas.eventservice.application.service

import com.volkswagenag.recall2.shared.application.service.CommandResponse

interface CommandBus {

    fun handle(command: Command): CommandResponse
}

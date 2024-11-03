package com.veloatlas.eventservice.application.service

import com.volkswagenag.recall2.shared.application.exception.mapper.DomainToApplicationExceptionCatcher
import com.volkswagenag.recall2.shared.application.service.CommandHandler
import com.volkswagenag.recall2.shared.application.service.CommandResponse
import com.volkswagenag.recall2.shared.domain.exception.HandlerNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.aop.support.AopUtils
import org.springframework.core.GenericTypeResolver
import org.springframework.stereotype.Service

@Service
class CommandBusImpl(
    commandHandlers: List<CommandHandler<*>>
) : CommandBus {
    private val commandHandlerMap = mutableMapOf<Class<Command>, CommandHandler<Command>>()
    private val logger = LoggerFactory.getLogger(CommandBusImpl::class.java)

    @Suppress("all")
    @DomainToApplicationExceptionCatcher
    override fun handle(command: Command): CommandResponse {
        val handler = getHandlerForCommand(command)
            ?: throw HandlerNotFoundException(
                mapOf(Pair("commandName", "$command")),
                "No command handler found for command $command"
            )

        return handler.execute(command)
    }

    private fun getHandlerForCommand(command: Command): CommandHandler<Command>? {
        return commandHandlerMap[command::class.java]
    }

    init {
        loadCommandHandlers(commandHandlers)
    }

    @Suppress("UNCHECKED_CAST")
    private fun loadCommandHandlers(commandHandlers: List<CommandHandler<*>>) {
        for (commandHandler in commandHandlers) {
            registerCommandHandler(commandHandler as CommandHandler<Command>)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun registerCommandHandler(handler: CommandHandler<Command>) {
        val typeArguments = GenericTypeResolver.resolveTypeArguments(
            AopUtils.getTargetClass(handler),
            CommandHandler::class.java
        ) ?: throw ClassNotFoundException("Could not resolve command class for command handler $handler ")

        val commandClass = typeArguments[0] as Class<Command>
        logger.info("registering command handler ${handler::class.java.name}")
        commandHandlerMap.putIfAbsent(commandClass, handler)

    }
}

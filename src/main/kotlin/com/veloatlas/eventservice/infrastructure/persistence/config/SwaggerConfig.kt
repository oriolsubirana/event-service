package com.veloatlas.eventservice.infrastructure.persistence.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun notificationApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("default")
            .pathsToMatch("/**")
            .build()
    }

    @Bean
    fun metaData(): OpenAPI? {
        return OpenAPI()
            .info(
                Info().title("Event Service API")
                    .description("Demo event-service endpoint operations")
            )
    }

}
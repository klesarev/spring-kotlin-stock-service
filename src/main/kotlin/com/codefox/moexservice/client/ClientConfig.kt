package com.codefox.moexservice.client

import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ClientConfig {
    @Bean
    fun clientLoggerLevel() = Logger.Level.BASIC
}
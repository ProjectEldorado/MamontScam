package com.nikego.configuration

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires

@ConfigurationProperties(LeonConfiguration.PREFIX)
@Requires(property = LeonConfiguration.PREFIX)
object LeonConfiguration {
    const val PREFIX = "leon"
    const val LEON_API_URL = "https://www.leon.bet/api-2"
}
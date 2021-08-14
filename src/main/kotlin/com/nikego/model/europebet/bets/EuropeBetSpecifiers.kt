package com.nikego.model.europebet.bets

import com.fasterxml.jackson.annotation.JsonProperty

data class EuropeBetSpecifiers(
    @JsonProperty("total") val total: String
)
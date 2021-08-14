package com.nikego.model.europebet.bets

import com.fasterxml.jackson.annotation.JsonProperty

data class EuropeBetOdd(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String?,
    @JsonProperty("outcomes") val outcomes: List<EuropeBetOutcome>,
    @JsonProperty("specifiers") val specifiers: EuropeBetSpecifiers?
)
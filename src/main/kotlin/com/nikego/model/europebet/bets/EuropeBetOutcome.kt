package com.nikego.model.europebet.bets

import com.fasterxml.jackson.annotation.JsonProperty

data class EuropeBetOutcome(
    @JsonProperty("id") val id: Int,
    @JsonProperty("outcome") val outcome: String,
    @JsonProperty("outcomeId") val outcomeId: String,
    @JsonProperty("status") val status: Int,
    @JsonProperty("oddValue") val oddValue: Double,
    @JsonProperty("providerTimestamp") val providerTimestamp: String
)
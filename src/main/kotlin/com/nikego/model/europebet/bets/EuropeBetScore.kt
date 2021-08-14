package com.nikego.model.europebet.bets

import com.fasterxml.jackson.annotation.JsonProperty

data class EuropeBetScore(
    @JsonProperty("CURRENT") val current: String
)
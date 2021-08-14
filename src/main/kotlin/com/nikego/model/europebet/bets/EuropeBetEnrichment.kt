package com.nikego.model.europebet.bets

import com.fasterxml.jackson.annotation.JsonProperty

data class EuropeBetEnrichment(
    @JsonProperty("animation") val animation: List<String>
)
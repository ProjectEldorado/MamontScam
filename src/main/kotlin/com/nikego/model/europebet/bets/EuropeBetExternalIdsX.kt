package com.nikego.model.europebet.bets

import com.fasterxml.jackson.annotation.JsonProperty

data class EuropeBetExternalIdsX(
    @JsonProperty("betradarUnified") val betradarUnified: String?,
    @JsonProperty("LSportsFeed") val lSportsFeed: String?
)
package com.nikego.model.europebet.bets

import com.fasterxml.jackson.annotation.JsonProperty

data class EuropeBetCompetitor(
    @JsonProperty("id") val id: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("externalIds") val externalIds: EuropeBetExternalIdsX?
)
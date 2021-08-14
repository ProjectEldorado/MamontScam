package com.nikego.model.europebet.bets

import com.fasterxml.jackson.annotation.JsonProperty

data class EuropeBetBet(
    @JsonProperty("id") val id: Int,
    @JsonProperty("providerTimestamp") val providerTimestamp: Long,
    @JsonProperty("sportsbookTimestamp") val sportsbookTimestamp: Long,
    @JsonProperty("name") val name: String?,
    @JsonProperty("startDate") val startDate: String,
    @JsonProperty("endDate") val endDate: String?,
    @JsonProperty("status") val status: Int,
    @JsonProperty("providerStatus") val providerStatus: String,
    @JsonProperty("eventType") val eventType: String,
    @JsonProperty("sportId") val sportId: Int,
    @JsonProperty("categoryId") val categoryId: Int,
    @JsonProperty("leagueId") val leagueId: Int,
    @JsonProperty("score") val score: EuropeBetScore?,
    @JsonProperty("externalIds") val externalIds: EuropeBetExternalIds?,
    @JsonProperty("oddsCount") val oddsCount: Int,
    @JsonProperty("totalOddsCount") val totalOddsCount: Int,
    @JsonProperty("competitors") val competitors: List<EuropeBetCompetitor>?,
    @JsonProperty("odds") val odds: List<EuropeBetOdd>?,
    @JsonProperty("enrichment") val enrichment: EuropeBetEnrichment?
)
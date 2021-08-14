package com.nikego.model.europebet.bets


import com.fasterxml.jackson.annotation.JsonProperty

data class EuropeBetExternalIds(
    @JsonProperty("betradarUnified") val betradarUnified: String?,
    @JsonProperty("betradar") val betradar: String?,
    @JsonProperty("aams") val aams: String?,
    @JsonProperty("BetradarCtrl") val betradarCtrl: String?,
    @JsonProperty("shortCode") val shortCode: String?
)
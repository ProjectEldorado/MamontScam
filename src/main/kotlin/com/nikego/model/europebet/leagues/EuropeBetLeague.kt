package com.nikego.model.europebet.leagues

import com.fasterxml.jackson.annotation.JsonProperty

data class EuropeBetLeague(
    @JsonProperty("categoryId") val categoryId: Int,
    @JsonProperty("externalIds") val externalIds: EuropeBetExternalIds?,
    @JsonProperty("featured") val featured: Boolean,
    @JsonProperty("featuredPriority") val featuredPriority: Int,
    @JsonProperty("id") val id: Int,
    @JsonProperty("inPlayMatchCount") val inPlayMatchCount: Int,
    @JsonProperty("inPlayTournamentCount") val inPlayTournamentCount: Int,
    @JsonProperty("matchCount") val matchCount: Int,
    @JsonProperty("name") val name: String,
    @JsonProperty("priority") val priority: Int,
    @JsonProperty("sportId") val sportId: Int,
    @JsonProperty("sportPriority") val sportPriority: Int,
    @JsonProperty("templateId") val templateId: Int,
    @JsonProperty("tournamentCount") val tournamentCount: Int
)

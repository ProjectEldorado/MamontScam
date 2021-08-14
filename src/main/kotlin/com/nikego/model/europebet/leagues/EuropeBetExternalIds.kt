package com.nikego.model.europebet.leagues

import com.fasterxml.jackson.annotation.JsonProperty

data class EuropeBetExternalIds(
    @JsonProperty("betradarUnified") val betradarUnified: String
)
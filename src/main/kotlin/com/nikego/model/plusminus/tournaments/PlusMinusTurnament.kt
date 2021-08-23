package com.nikego.model.plusminus.tournaments


import com.fasterxml.jackson.annotation.JsonProperty

data class PlusMinusTurnament(
    @JsonProperty("__type") val type: String,
    @JsonProperty("RatingViewSport") val ratingViewSport: Int,
    @JsonProperty("RatingViewTournament") val ratingViewTournament: Int,
    @JsonProperty("SportId") val sportId: Int,
    @JsonProperty("CountryId") val countryId: Int,
    @JsonProperty("ID") val iD: Int,
    @JsonProperty("Name") val name: String,
    @JsonProperty("Count") val count: Int,
    @JsonProperty("MinDateEvent") val minDateEvent: String,
    @JsonProperty("MaxDateEvent") val maxDateEvent: String,
    @JsonProperty("RealtionSportId") val realtionSportId: Int
)
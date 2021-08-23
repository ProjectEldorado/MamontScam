package com.nikego.model.plusminus.tournaments


import com.fasterxml.jackson.annotation.JsonProperty

data class PlusMinusDTournaments(
    @JsonProperty("Sport") val sport: PlusMinusSport,
    @JsonProperty("Country") val country: PlusMinusCountry,
    @JsonProperty("Turnaments") val turnaments: List<PlusMinusTurnament>
)
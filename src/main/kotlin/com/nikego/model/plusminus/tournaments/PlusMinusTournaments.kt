package com.nikego.model.plusminus.tournaments


import com.fasterxml.jackson.annotation.JsonProperty

data class PlusMinusTournaments(
    @JsonProperty("d") val dTournaments: PlusMinusDTournaments
)
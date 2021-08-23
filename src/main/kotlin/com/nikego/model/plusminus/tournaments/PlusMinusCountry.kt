package com.nikego.model.plusminus.tournaments


import com.fasterxml.jackson.annotation.JsonProperty

data class PlusMinusCountry(
    @JsonProperty("Name") val name: String,
    @JsonProperty("ID") val iD: Int
)
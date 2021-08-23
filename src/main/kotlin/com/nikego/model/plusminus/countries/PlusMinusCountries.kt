package com.nikego.model.plusminus.countries


import com.fasterxml.jackson.annotation.JsonProperty

data class PlusMinusCountries(
    @JsonProperty("d") val dCountries: List<PlusMinusDCountry>
)
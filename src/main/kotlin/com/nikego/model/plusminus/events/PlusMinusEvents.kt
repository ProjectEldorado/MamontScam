package com.nikego.model.plusminus.events


import com.fasterxml.jackson.annotation.JsonProperty

data class PlusMinusEvents(
    @JsonProperty("d") val dEvents: List<PlusMinusDEvent>
)
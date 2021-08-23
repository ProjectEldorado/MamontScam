package com.nikego.model.plusminus.events


import com.fasterxml.jackson.annotation.JsonProperty

data class PlusMinusAddToBasket(
    @JsonProperty("eId") val eId: Int,
    @JsonProperty("bId") val bId: Int,
    @JsonProperty("r") val r: Double,
    @JsonProperty("fs") val fs: Any?,
    @JsonProperty("a1") val a1: Any?,
    @JsonProperty("a2") val a2: Any?,
    @JsonProperty("EG") val eG: Int,
    @JsonProperty("isLive") val isLive: Boolean
)
package com.nikego.model.plusminus.events


import com.fasterxml.jackson.annotation.JsonProperty

data class PlusMinusRate(
    @JsonProperty("Rate") val rate: String,
    @JsonProperty("NameShort") val nameShort: String,
    @JsonProperty("NameLong") val nameLong: String,
    @JsonProperty("NameLongOrig") val nameLongOrig: String,
    @JsonProperty("BN") val bN: Any?,
    @JsonProperty("IsCashOut") val isCashOut: Boolean,
    @JsonProperty("BetId") val betId: Int,
    @JsonProperty("AddToBasket") val addToBasket: PlusMinusAddToBasket,
    @JsonProperty("S") val s: Int,
    @JsonProperty("N") val n: Int
)
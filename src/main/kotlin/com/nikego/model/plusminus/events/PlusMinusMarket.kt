package com.nikego.model.plusminus.events


import com.fasterxml.jackson.annotation.JsonProperty

data class PlusMinusMarket(
    @JsonProperty("Id") val id: String,
    @JsonProperty("IsEnabled") val isEnabled: Boolean,
    @JsonProperty("Caption") val caption: String,
    @JsonProperty("TemlateType") val temlateType: String,
    @JsonProperty("IsMain") val isMain: Boolean,
    @JsonProperty("ViewBetGroup") val viewBetGroup: Int,
    @JsonProperty("ViewBetType") val viewBetType: Int,
    @JsonProperty("Rates") val rates: List<PlusMinusRate>,
    @JsonProperty("SortKey") val sortKey: Int
)
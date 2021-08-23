package com.nikego.model.plusminus.events


import com.fasterxml.jackson.annotation.JsonProperty

data class PlusMinusDEvent(
    @JsonProperty("__type") val type: String,
    @JsonProperty("Id") val id: Int,
    @JsonProperty("SId") val sId: Int,
    @JsonProperty("TId") val tId: Int,
    @JsonProperty("CId") val cId: Int,
    @JsonProperty("TeamsGroup") val teamsGroup: List<String>,
    @JsonProperty("Date") val date: String,
    @JsonProperty("SportName") val sportName: String,
    @JsonProperty("TournamentName") val tournamentName: String,
    @JsonProperty("CountryName") val countryName: String,
    @JsonProperty("Comment") val comment: String,
    @JsonProperty("MarketsCount") val marketsCount: Int,
    @JsonProperty("PriceNum") val priceNum: Int,
    @JsonProperty("Dsc") val dsc: Any?,
    @JsonProperty("Markets") val markets: List<PlusMinusMarket>,
    @JsonProperty("Groups") val groups: List<Any>,
    @JsonProperty("IsStat") val isStat: Boolean,
    @JsonProperty("StParam") val stParam: String,
    @JsonProperty("RatingViewSport") val ratingViewSport: Int,
    @JsonProperty("RatingViewTournament") val ratingViewTournament: Int
)
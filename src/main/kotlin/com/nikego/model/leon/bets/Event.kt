package com.nikego.model.leon.bets

data class Event(
    val betline: String,
    val competitors: List<Competitor>,
    val id: Long,
    val kickoff: Long,
    val lastUpdated: Long,
    val league: League,
    val markets: List<Market>,
    val marketsCount: Int,
    val matchPhase: String,
    val name: String,
    val nameDefault: String,
    val native: Boolean,
    val `open`: Boolean,
    val status: String,
    val url: String,
    val widgetType: String
)
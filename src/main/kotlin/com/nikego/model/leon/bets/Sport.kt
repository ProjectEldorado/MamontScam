package com.nikego.model.leon.bets

data class Sport(
    val family: String,
    val id: Long,
    val mainMarkets: List<MainMarket>,
    val name: String,
    val url: String,
    val weight: Int
)

package com.nikego.model.leon.bets

data class MainMarket(
    val altMarketTypeIds: List<Long>,
    val id: Long,
    val name: String,
    val virtual: Boolean,
    val weight: Int
)
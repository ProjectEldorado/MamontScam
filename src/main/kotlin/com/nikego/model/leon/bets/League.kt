package com.nikego.model.leon.bets

data class League(
    val id: Long,
    val inplay: Int,
    val name: String,
    val nameDefault: String,
    val outright: Int,
    val prematch: Int,
    val region: String,
    val regionDefault: String,
    val sport: Sport,
    val top: Boolean,
    val url: String,
    val weight: Int
)

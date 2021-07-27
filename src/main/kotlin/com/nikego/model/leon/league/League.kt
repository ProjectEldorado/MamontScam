package com.nikego.model.leon.league

data class League(
    val id: Long,
    val inplay: Int,
    val name: String,
    val nameDefault: String,
    val outright: Int,
    val prematch: Int,
    val top: Boolean,
    val topOrder: Int,
    val url: String,
    val weight: Int
)
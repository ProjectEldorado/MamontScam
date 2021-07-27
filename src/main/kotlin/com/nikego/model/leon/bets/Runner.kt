package com.nikego.model.leon.bets

data class Runner(
    val c: Int,
    val id: Long,
    val name: String,
    val `open`: Boolean,
    val price: Double,
    val r: Int,
    val tags: List<String>
)
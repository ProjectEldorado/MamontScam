package com.nikego.model.leon.bets

data class Market(
    val cols: Int,
    val id: Long,
    val marketTypeId: Long,
    val name: String,
    val `open`: Boolean,
    val primary: Boolean,
    val runners: List<Runner>
)


package com.nikego.model.leon.league

data class LeonSportsItem(
    val family: String,
    val id: Long,
    val name: String,
    val regions: List<Region>,
    val weight: Int
)
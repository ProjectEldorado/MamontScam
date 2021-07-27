package com.nikego.model.leon.league

data class Region(
    val id: Long,
    val leagues: List<League>,
    val name: String,
    val nameDefault: String,
    val url: String
)
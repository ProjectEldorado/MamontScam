package com.nikego.model.base.uni

data class Uni(
    val localId: String,
    val eventDate: Long,
    val eventName: String,
    val betDiscipline: BetDiscipline,
    val siteUrl: String,
    val isLive: Boolean,
    val firstTeam: String,
    val secondTeam: String,
    val betType:BetType,
    val betTypeData: BetTypeData
)

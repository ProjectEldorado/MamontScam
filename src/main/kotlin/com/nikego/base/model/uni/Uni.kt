package com.nikego.base.model.uni

data class Uni(
    val localId: String,
    val eventDate: Long,
    val eventName: String,
    val betDiscipline: BetDiscipline,
    val siteUrl: String,
    val isLive: Boolean,
    val firstTeam: String,
    val secondTeam: String,
    val betTypeData: BetTypeData
)

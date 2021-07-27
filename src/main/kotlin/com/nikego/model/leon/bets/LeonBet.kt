package com.nikego.model.leon.bets

import com.nikego.base.model.BettingData

data class LeonBet(
    val betline: Any?,
    val enabled: Boolean,
    val events: List<Event>,
    val totalCount: Int,
    val vtag: String
) : BettingData
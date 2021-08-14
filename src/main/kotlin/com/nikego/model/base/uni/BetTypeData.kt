package com.nikego.model.base.uni

sealed class BetTypeData {

    data class WinLoseBet(
        val firstTeamCoefficient: Double,
        val secondTeamCoefficient: Double,
        val drawCoefficient: Double?
    ) : BetTypeData()

    data class TotalBet(val totalValue: Double) : BetTypeData()
}
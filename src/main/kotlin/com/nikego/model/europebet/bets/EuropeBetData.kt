package com.nikego.model.europebet.bets

import com.nikego.model.base.BettingData

data class EuropeBetData(val europeBetBets: List<EuropeBetBet>) : BettingData {
    override val companyName: String = "EuropeBet"
}
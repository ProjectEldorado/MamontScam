package com.nikego.utils.extensions

import com.nikego.model.base.BetCompany
import com.nikego.model.base.uni.BetType
import com.nikego.model.base.uni.BetTypeData
import com.nikego.model.base.uni.Uni
import com.nikego.model.europebet.bets.EuropeBetBet
import com.nikego.model.plusminus.events.PlusMinusDEvent
import com.nikego.utils.Try
import java.text.SimpleDateFormat


fun EuropeBetBet.toUni() = Try.runSafely {
    Uni(
        localId = id.toString(),
        eventDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(startDate).time,
        eventName = competitors?.joinToString(" - ") { it.name }
            ?: throw IllegalArgumentException("null competitors"),
        betDiscipline = BetCompany.EUROPE_BET.betDisciplineToId.entries.find { it.value == sportId }?.key
            ?: throw IllegalArgumentException("unsupported sport"),
        siteUrl = "",
        isLive = false,
        firstTeam = competitors.first().name,
        secondTeam = competitors.last().name,
        betType = BetType.WIN_LOSE,
        betTypeData = odds?.find { it.name == "1X2" }?.let { europeBetOdd ->
            BetTypeData.WinLoseBet(
                firstTeamCoefficient = europeBetOdd.outcomes.find { it.outcome.contains("competitor1") }?.oddValue
                    ?: throw IllegalArgumentException("null first coefficient"),
                secondTeamCoefficient = europeBetOdd.outcomes.find { it.outcome.contains("competitor2") }?.oddValue
                    ?: throw IllegalArgumentException("null second oefficient"),
                drawCoefficient = europeBetOdd.outcomes.find { it.outcome == "X" }?.oddValue
            )
        } ?: throw IllegalArgumentException("coefficients not found")
    )
}

fun PlusMinusDEvent.toUni() = Try.runSafely {
    fun String.parseDouble() = replace(',', '.').toDouble()
    Uni(
        localId = id.toString(),
        eventDate = date.substringAfter('(').substringBefore(')').toLong(),
        eventName = teamsGroup.joinToString(" - "),
        betDiscipline = BetCompany.EUROPE_BET.betDisciplineToId.entries.find { it.value == sId }?.key
            ?: throw IllegalArgumentException("unsupported sport"),
        siteUrl = "",
        isLive = false,
        firstTeam = teamsGroup.first(),
        secondTeam = teamsGroup.last(),
        betType = BetType.WIN_LOSE,
        betTypeData = markets.first().let { plusMinusMarket ->
            BetTypeData.WinLoseBet(
                firstTeamCoefficient = plusMinusMarket.rates.find { it.nameShort == "1" }?.rate?.parseDouble()
                    ?: throw IllegalArgumentException("null first coefficient"),
                secondTeamCoefficient = plusMinusMarket.rates.find { it.nameShort == "2" }?.rate?.parseDouble()
                    ?: throw IllegalArgumentException("null second coefficient"),
                drawCoefficient = plusMinusMarket.rates.find { it.nameShort == "X" }?.rate?.parseDouble()
            )
        }
    )
}
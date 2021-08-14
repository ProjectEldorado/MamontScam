package com.nikego.utils.extensions

import com.google.protobuf.DoubleValue
import com.google.protobuf.Timestamp
import com.nikego.UniBet
import com.nikego.model.base.uni.*
import com.nikego.BetDiscipline as BetDisciplineProto
import com.nikego.BetType as BetTypeProto
import com.nikego.BetsData as BetsDataProto
import com.nikego.TotalBet as TotalBetProto
import com.nikego.WinLoseBet as WinLoseBetProto

fun BetsData.toBetsDataProto() =
    BetsDataProto.newBuilder()
        .setCompanyName(companyName)
        .addAllUniBets(uni.map { it.toUniBetProto() })
        .build()

fun Uni.toUniBetProto() =
    UniBet.newBuilder()
        .setLocalId(localId)
        .setEventName(eventName)
        .setSiteUrl(siteUrl)
        .setIsLive(isLive)
        .setFirstTeam(firstTeam)
        .setSecondTeam(secondTeam)
        .setEventDate(Timestamp.newBuilder().setSeconds(eventDate / 1000).build())
        .setBetType(
            when (betType) {
                BetType.TOTAL -> BetTypeProto.WinLose
                BetType.WIN_LOSE -> BetTypeProto.Total
            }
        ).apply {
            when (betTypeData) {
                is BetTypeData.TotalBet -> totalData = TotalBetProto.newBuilder()
                    .setTotalValue(betTypeData.totalValue).build()
                is BetTypeData.WinLoseBet -> winLoseData = WinLoseBetProto.newBuilder()
                    .setFirstTeamCoefficient(betTypeData.firstTeamCoefficient)
                    .setSecondTeamCoefficient(betTypeData.secondTeamCoefficient)
                    .setDrawCoefficient(betTypeData.drawCoefficient?.let { DoubleValue.of(it) }
                        ?: DoubleValue.getDefaultInstance())
                    .build()
            }
        }
        .build()

fun BetDisciplineProto.toBetDiscipline() =
    when (this) {
        BetDisciplineProto.Football -> BetDiscipline.FOOTBALL
        BetDisciplineProto.CyberSport -> BetDiscipline.CYBER_SPORT
        com.nikego.BetDiscipline.UNRECOGNIZED -> null
    }
package com.nikego.mappers.europebet

import com.nikego.model.base.uni.BetsData
import com.nikego.model.europebet.bets.EuropeBetData
import com.nikego.utils.Mapper

object EuropeBetMapper : Mapper<EuropeBetData> {

    override fun map(bettingData: EuropeBetData): BetsData =
        BetsData(bettingData.companyName, emptyList())
}
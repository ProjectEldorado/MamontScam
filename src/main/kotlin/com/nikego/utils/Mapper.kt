package com.nikego.utils

import com.nikego.model.base.BettingData
import com.nikego.model.base.uni.BetsData

interface Mapper<in T : BettingData> {
    fun map(bettingData: T): BetsData
}
package com.nikego.base.util

import com.nikego.base.model.BettingData
import com.nikego.base.model.uni.BetsData


interface Mapper<in T : BettingData> {
    fun map(bettingData: T): BetsData
}
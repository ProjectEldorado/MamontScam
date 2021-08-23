package com.nikego.model.base

import com.nikego.model.base.uni.BetDiscipline

enum class BetCompany(
    val companyName: String,
    val allowedDisciplineIds: List<Int>,
    val betDisciplineToId: Map<BetDiscipline, Int>
) {
    EUROPE_BET("BetCity", listOf(1), mapOf(BetDiscipline.FOOTBALL to 1)),
    PLUS_MINUS("PlusMinus", listOf(5), mapOf(BetDiscipline.FOOTBALL to 1));

    fun fromCompanyName(name: String) =
        values().find { it.companyName.equals(name, ignoreCase = true) }
}
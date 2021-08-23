package com.nikego.repositories

import com.nikego.model.base.uni.BetDiscipline
import com.nikego.utils.extensions.getSuccess
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class PlusMinusRepositoryTest(private val plusMinusRepository: PlusMinusRepository) {

    @Test
    fun `test get bets`() {
        plusMinusRepository.getBetsData(listOf(BetDiscipline.FOOTBALL))
            .toList()
            .blockingGet()
            .let {
                println(it.size)
                println(it.getSuccess().size)
            }
    }
}
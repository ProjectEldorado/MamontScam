package com.nikego

import com.nikego.domain.MamontScamReshaet
import com.nikego.model.base.uni.BetDiscipline
import com.nikego.model.domain.BetRequest
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class ReshaloTest(private val mamontScamReshaet: MamontScamReshaet) {

    @Test
    fun `test reshalo`() {
        mamontScamReshaet.getBetsData(BetRequest(listOf(BetDiscipline.FOOTBALL)))
            .blockingGet()
            .also { bets ->
                println(bets.find { it.companyName == "PlusMinus" }?.uni?.size)
                println(bets.flatMap { it.uni }.size)
            }
    }
}
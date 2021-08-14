package com.nikego.grpc

import com.nikego.BetsData
import com.nikego.DataAdapterConfiguration
import com.nikego.RxDataAdapterServiceGrpc
import com.nikego.clients.EuropeBetApi
import com.nikego.mappers.europebet.EuropeBetMapper
import com.nikego.model.europebet.bets.EuropeBetData
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class MamontScamTestGrpcService(private val europeBetApi: EuropeBetApi) :
    RxDataAdapterServiceGrpc.DataAdapterServiceImplBase() {

    override fun loadData(request: Single<DataAdapterConfiguration>?): Single<BetsData> =
        request?.let {
            europeBetApi.getLeagues()
                .filter { it.sportId == 1 && it.matchCount > 0 }
                .map { it.id }
                .flatMap { europeBetApi.getBets(it) }
                .toList()
                .map { EuropeBetMapper.map(EuropeBetData(it)) }
                .map {
                    BetsData.newBuilder()
                        .setCompanyName(it.companyName)
                        .build()
                }
        } ?: Single.just(BetsData.newBuilder().setCompanyName("huy").build())
}
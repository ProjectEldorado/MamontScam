package com.nikego.service

import com.nikego.BetsData
import com.nikego.DataAdapterConfiguration
import com.nikego.RxDataAdapterServiceGrpc
import com.nikego.domain.MamontScamReshaet
import com.nikego.model.domain.BetRequest
import com.nikego.utils.extensions.toBetDiscipline
import com.nikego.utils.extensions.toBetsDataProto
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class DataAdapterGrpcService(private val mamontScamReshaet: MamontScamReshaet) :
    RxDataAdapterServiceGrpc.DataAdapterServiceImplBase() {

    override fun loadData(request: Single<DataAdapterConfiguration>?): Single<BetsData> =
        request?.let { mamontRequest ->
            mamontRequest
                .map { configuration -> BetRequest(configuration.disciplinesList.mapNotNull { it.toBetDiscipline() }) }
                .flatMap { mamontScamReshaet.getBetsData(it) }
                .map { betsData -> betsData.toBetsDataProto() }
        } ?: Single.just(BetsData.getDefaultInstance())
}
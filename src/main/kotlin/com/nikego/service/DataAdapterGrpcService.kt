package com.nikego.service

import com.nikego.BetsData
import com.nikego.DataAdapterConfiguration
import com.nikego.RxDataAdapterServiceGrpc
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class DataAdapterGrpcService : RxDataAdapterServiceGrpc.DataAdapterServiceImplBase() {

    override fun loadData(request: Single<DataAdapterConfiguration>?): Single<BetsData> {
        return super.loadData(request)
    }
}
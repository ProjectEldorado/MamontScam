package com.nikego.service

import com.example.BetsData
import com.example.DataAdapterConfiguration
import com.example.RxDataAdapterServiceGrpc
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class DataAdapterGrpcService : RxDataAdapterServiceGrpc.DataAdapterServiceImplBase() {

    override fun loadData(request: Single<DataAdapterConfiguration>?): Single<BetsData> {
        return super.loadData(request)
    }
}
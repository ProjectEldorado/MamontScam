package com.nikego.grpc

import com.nikego.DataAdapterConfiguration
import com.nikego.RxDataAdapterServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import io.micronaut.grpc.server.GrpcServerChannel
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject
import javax.inject.Singleton

@MicronautTest
class MamontScamGrpcTest {

    @Inject
    lateinit var mamontScamGrpcClient: RxDataAdapterServiceGrpc.RxDataAdapterServiceStub

    @Test
    fun testClientGet() {
        mamontScamGrpcClient.loadData(DataAdapterConfiguration.getDefaultInstance())
            .blockingGet()
            .also { println(it) }
    }
}

@Factory
class Clients {

    @Singleton
    fun mamontScamGrpcClient(@GrpcChannel(GrpcServerChannel.NAME) channel: ManagedChannel) =
        RxDataAdapterServiceGrpc.newRxStub(channel)
}
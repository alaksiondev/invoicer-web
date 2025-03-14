package features.data.impl.auth.datasource

import features.data.api.auth.datasource.AuthDataSource
import features.data.api.auth.model.*
import foundation.network.HttpWrapper
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class AuthDataSourceImpl(
    private val httpWrapper: HttpWrapper,
    private val dispatcher: CoroutineDispatcher,
) : AuthDataSource {
    override suspend fun login(requestData: LoginRequestData): AuthTokenResponseData {
        return withContext(dispatcher) {
            httpWrapper.client.post("v1/auth/login") {
                setBody(requestData)
            }
        }.body()
    }

    override suspend fun craeteAccount(requestData: CreateAccountRequestData) {
        return withContext(dispatcher) {
            httpWrapper.client.post("v1/auth/signup") {
                setBody(requestData)
            }
        }.body()
    }

    override suspend fun requestLoginQrCode(): QrCodeResponse {
        return withContext(dispatcher) {
            httpWrapper.client.post("/v1/auth/login/code") {
                setBody(QrCodeRequest(size = 256))
            }.body()
        }
    }
}
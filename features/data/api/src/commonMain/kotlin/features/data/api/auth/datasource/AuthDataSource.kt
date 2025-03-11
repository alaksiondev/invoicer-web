package features.data.api.auth.datasource

import features.data.api.auth.model.AuthTokenResponseData
import features.data.api.auth.model.CreateAccountRequestData
import features.data.api.auth.model.LoginRequestData
import features.data.api.auth.model.QrCodeResponse

interface AuthDataSource {
    suspend fun login(requestData: LoginRequestData): AuthTokenResponseData

    suspend fun craeteAccount(requestData: CreateAccountRequestData)

    suspend fun requestLoginQrCode(): QrCodeResponse
}
package com.sho.masegi.bookdore.network

import com.sho.masegi.bookdore.network.API.*
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.http.Url
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class Networking(val client: HttpClient) {

    suspend inline fun <reified T> request(api: BDAPI): Deferred<T> =
        GlobalScope.async {
            when(api.method) {
                Method.get -> client.use { it.get<T>(api) }
                Method.post -> client.use { it.post<T>(api)}
            }
        }
}

suspend inline fun <reified T>HttpClient.get(api: BDAPI): T {
    val httpRequestBuilder: HttpRequestBuilder.() -> Unit = {
        headers {
            api.headers?.forEach { (key, value) -> append(key, value) }
        }
    }
    return this.get(Url(api.endpoint()), httpRequestBuilder)
}

suspend inline fun <reified T>HttpClient.post(api: BDAPI): T {
    val httpRequestBuilder: HttpRequestBuilder.() -> Unit = {
        headers {
            api.headers?.forEach { (key, value) -> append(key, value) }
        }
    }
    return this.post(Url(api.endpoint()), httpRequestBuilder)
}

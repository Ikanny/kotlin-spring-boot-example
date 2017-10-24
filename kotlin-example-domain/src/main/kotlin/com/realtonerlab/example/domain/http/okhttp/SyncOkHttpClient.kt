package com.realtonerlab.example.domain.http.okhttp

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.base.Preconditions
import com.realtonerlab.example.domain.http.HttpResponse
import com.realtonerlab.example.domain.http.KotlinExampleHttpException
import com.realtonerlab.example.domain.http.SyncHttpClient
import okhttp3.*
import org.springframework.util.StringUtils

/**
 * @author ryuikhan
 * @since 2017. 10. 24.
 */
class SyncOkHttpClient(private val okHttpClient: OkHttpClient = OkHttpClient(),
                       private val objectMapper: ObjectMapper) : SyncHttpClient {
    companion object {
        private val JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8")
    }

    private fun buildRequest(url: String, headers: Array<out Pair<String, String>>): Request.Builder  {
        val builder = Request.Builder().url(url)
        return headers.fold(builder) { b, (name, value) -> b.addHeader(name.toLowerCase(), value) }
    }

    private fun <P> responseToHttpResponse(response: Response, clazz: Class<P>): HttpResponse<P> =
            HttpResponse(response.code(), response.headers().toMultimap(), response.body()?.let {
                objectMapper.readValue(it.bytes(), clazz)
            })

    override fun <P> get(url: String, clazz: Class<P>, vararg headers: Pair<String, String>): HttpResponse<P> {
        Preconditions.checkArgument(!StringUtils.isEmpty(url))

        val request = buildRequest(url, headers).get().build()
        var response: Response? = null

        try {
            response = okHttpClient.newCall(request).execute()
            return response?.let { responseToHttpResponse(it, clazz) } ?: throw KotlinExampleHttpException()
        } catch(e: Exception) {
            throw KotlinExampleHttpException(exception = e)
        } finally {
            response?.close()
        }

    }

    override fun <Q, P> post(url: String, clazz: Class<P>, requestBody: Q, vararg headers: Pair<String, String>): HttpResponse<P> {
        Preconditions.checkArgument(!StringUtils.isEmpty(url))

        val request = buildRequest(url, headers)
                .post(RequestBody.create(JSON_MEDIA_TYPE, objectMapper.writeValueAsString(requestBody)))
                .build()

        var response: Response? = null

        try {
            response = okHttpClient.newCall(request).execute()
            return response?.let { responseToHttpResponse(it, clazz) } ?: throw KotlinExampleHttpException()
        } catch(e: Exception) {
            throw KotlinExampleHttpException(exception = e)
        } finally {
            response?.close()
        }
    }
}
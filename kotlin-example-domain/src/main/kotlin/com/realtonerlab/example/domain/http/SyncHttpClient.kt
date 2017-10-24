package com.realtonerlab.example.domain.http

/**
 * @author ryuikhan
 * @since 2017. 10. 24.
 */
data class HttpResponse<P>(val statusCode: Int, val responseHeader: Map<String, List<String>>, val body: P?)

interface SyncHttpClient {

    fun <P> get(url: String, clazz: Class<P>, vararg headers: Pair<String, String>): HttpResponse<P>?
    fun <Q, P> post(url: String, clazz: Class<P>, requestBody: Q, vararg headers: Pair<String, String>): HttpResponse<P>?
}
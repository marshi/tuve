package marshi.android.tuve.repository.api

import okhttp3.Interceptor
import okhttp3.Response

class HttpLogginInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request = chain.request()
    val response = chain.proceed(request)
    println(response.body())
    return response
  }
}
package marshi.android.feedpond.repository

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
package marshi.android.feedpond.repository.feedly

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import marshi.android.feedpond.repository.HttpLogginInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FeedlyRepository {
  
  fun auth(): Single<String?> {
    val client = Retrofit.Builder().baseUrl("https://cloud.feedly.com")
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .client(OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLogginInterceptor())
        .build()
      ).build()
      .create(FeedlyApiClient::class.java)
    return client.auth().subscribeOn(Schedulers.io())
  }
  
}
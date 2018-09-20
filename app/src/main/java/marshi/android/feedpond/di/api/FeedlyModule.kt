package marshi.android.feedpond.di.api

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import marshi.android.feedpond.di.annotation.IdentityGson
import marshi.android.feedpond.repository.feedly.FeedlyApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class FeedlyModule {
  
  @Provides
  @Singleton
  fun provideFeedlyApiClient(
    builder: Retrofit.Builder,
    @IdentityGson gsonBuilder: GsonBuilder
  ): FeedlyApiClient {
    return builder
      .addConverterFactory(
        GsonConverterFactory.create(gsonBuilder.create())
      )
      .baseUrl("https://cloud.feedly.com")
      .build()
      .create(FeedlyApiClient::class.java)
  }
  
}

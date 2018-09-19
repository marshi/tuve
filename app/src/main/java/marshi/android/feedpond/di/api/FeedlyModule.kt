package marshi.android.feedpond.di.api

import dagger.Module
import dagger.Provides
import marshi.android.feedpond.repository.feedly.FeedlyApiClient
import marshi.android.feedpond.repository.feedly.FeedlyClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class FeedlyModule {
  
  @Provides
  @Singleton
  fun provideFeedlyApiClient(
    @FeedlyClient builder: Retrofit.Builder
  ): FeedlyApiClient {
    return builder.baseUrl("https://cloud.feedly.com").build().create(FeedlyApiClient::class.java)
  }
  
}

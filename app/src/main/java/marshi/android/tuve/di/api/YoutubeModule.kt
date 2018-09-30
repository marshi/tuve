package marshi.android.tuve.di.api

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import marshi.android.tuve.di.annotation.IdentityGson
import marshi.android.tuve.repository.youtube.YoutubeApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class YoutubeModule {
  
  @Provides
  @Singleton
  fun provideClient(
    builder: Retrofit.Builder,
    @IdentityGson gsonBuilder: GsonBuilder
  ): YoutubeApiClient {
    return builder
      .addConverterFactory(
        GsonConverterFactory.create(gsonBuilder.create())
      )
      .baseUrl("https://www.googleapis.com")
      .build()
      .create(YoutubeApiClient::class.java)
  }
  
}

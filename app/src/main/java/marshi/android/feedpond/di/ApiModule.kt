package marshi.android.feedpond.di

import dagger.Module
import dagger.Provides
import marshi.android.feedpond.di.api.FeedlyModule
import marshi.android.feedpond.repository.feedly.FeedlyClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [
  FeedlyModule::class
])
open class ApiModule {
  
  @FeedlyClient
  @Provides
  @Singleton
  fun provideRetrofitBuilder(): Retrofit.Builder {
    return Retrofit.Builder()
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
  }
  
}

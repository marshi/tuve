package marshi.android.tuve.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import marshi.android.tuve.di.annotation.IdentityGson
import marshi.android.tuve.di.api.FeedlyModule
import marshi.android.tuve.di.api.YoutubeModule
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [
  FeedlyModule::class,
  YoutubeModule::class
])
class ApiModule {
  
  @Provides
  @Singleton
  fun provideRetrofitBuilder(): Retrofit.Builder {
    return Retrofit.Builder()
      .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()))
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
  }
  
  @Provides
  @Singleton
  fun provideGsonBuilder(): GsonBuilder {
    return GsonBuilder()
  }
  
  @Provides
  @IdentityGson
  fun provideIdentityGson(
    builder: GsonBuilder
  ): GsonBuilder {
    return builder
      .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
  }

}

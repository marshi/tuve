package marshi.android.tuve.di

import dagger.Module
import marshi.android.tuve.di.activity.MainActivityModuleBuilder
import marshi.android.tuve.channelVideoList.ChannelVideoListActivityModule
import marshi.android.tuve.search.SearchActivityModuleBuilder

@Module(includes = [
  MainActivityModuleBuilder::class,
  SearchActivityModuleBuilder::class,
  ChannelVideoListActivityModule::class
])
interface ActivityModules

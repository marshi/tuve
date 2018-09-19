package marshi.android.feedpond.di

import dagger.Module
import marshi.android.feedpond.di.activity.MainActivityModuleBuilder
import marshi.android.feedpond.search.SearchActivityModuleBuilder

@Module(includes = [
  MainActivityModuleBuilder::class,
  SearchActivityModuleBuilder::class
])
interface ActivityModules

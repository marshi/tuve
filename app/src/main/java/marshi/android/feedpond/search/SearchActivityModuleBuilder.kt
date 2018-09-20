package marshi.android.feedpond.search

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.feedpond.di.ActivityScope

@Module
interface SearchActivityModuleBuilder {
  @ActivityScope
  @ContributesAndroidInjector()
  fun contributeSearchActivity(): SearchActivity
}


package marshi.android.tuve.ui.search

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.tuve.di.ActivityScope

@Module
interface SearchActivityModuleBuilder {
  @ActivityScope
  @ContributesAndroidInjector()
  fun contributeSearchActivity(): SearchActivity
}


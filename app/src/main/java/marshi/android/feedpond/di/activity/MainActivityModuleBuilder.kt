package marshi.android.feedpond.di.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.feedpond.MainActivity
import marshi.android.feedpond.di.ActivityScope
import marshi.android.feedpond.feedlist.FeedListFragmentModule

@Module interface MainActivityModuleBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [FeedListFragmentModule::class])
    fun contributeMainActivity(): MainActivity
}


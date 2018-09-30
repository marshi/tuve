package marshi.android.tuve.di.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.tuve.MainActivity
import marshi.android.tuve.di.ActivityScope
import marshi.android.tuve.feedlist.FeedListFragmentModule

@Module interface MainActivityModuleBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [FeedListFragmentModule::class])
    fun contributeMainActivity(): MainActivity
}


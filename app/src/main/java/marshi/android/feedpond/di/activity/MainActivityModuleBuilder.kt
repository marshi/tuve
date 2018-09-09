package marshi.android.feedpond.di.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.feedpond.FeedListFragment
import marshi.android.feedpond.MainActivity

@Module interface MainActivityModuleBuilder {
//    @ActivityScope
    @ContributesAndroidInjector(modules = [FeedListFragmentModule::class])
    fun contributeMainActivity(): MainActivity


    @ContributesAndroidInjector
    fun contributeFeedListFragment(): FeedListFragment
}


ｔ
package marshi.android.tuve.di.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.tuve.MainActivity
import marshi.android.tuve.di.ActivityScope
import marshi.android.tuve.recommendVideoList.RecommendVideoListFragmentModule

@Module interface MainActivityModuleBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [RecommendVideoListFragmentModule::class])
    fun contributeMainActivity(): MainActivity
}


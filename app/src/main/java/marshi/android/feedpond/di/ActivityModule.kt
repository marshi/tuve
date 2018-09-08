package marshi.android.feedpond.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.feedpond.MainActivity

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity

}
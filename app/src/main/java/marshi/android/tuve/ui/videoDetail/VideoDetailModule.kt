package marshi.android.tuve.ui.videoDetail

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.tuve.di.FragmentScope

@Module
interface VideoDetailModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun bindsVideoDetailFragment(): VideoDetailFragment
}
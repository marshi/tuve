package marshi.android.tuve.ui.channelVideoList

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.tuve.di.ActivityScope

@Module
interface ChannelVideoListActivityModule {
  @ActivityScope
  @ContributesAndroidInjector
  fun contributeActivity(): ChannelVideoListActivity
}

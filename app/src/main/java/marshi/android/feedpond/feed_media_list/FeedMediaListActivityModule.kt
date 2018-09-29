package marshi.android.feedpond.feed_media_list

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.feedpond.di.ActivityScope

@Module
interface FeedMediaListActivityModule {
  @ActivityScope
  @ContributesAndroidInjector
  fun contributeActivity(): FeedMediaListActivity
}

package marshi.android.tuve.feed_media_list

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.tuve.di.ActivityScope

@Module
interface FeedMediaListActivityModule {
  @ActivityScope
  @ContributesAndroidInjector
  fun contributeActivity(): FeedMediaListActivity
}

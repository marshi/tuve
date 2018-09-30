package marshi.android.tuve.feedlist

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.tuve.FeedListFragment
import marshi.android.tuve.di.FragmentScope

@Module
interface FeedListFragmentModule {
  
  @FragmentScope
  @ContributesAndroidInjector
  fun contributeFeedListFragment(): FeedListFragment
  
}

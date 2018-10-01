package marshi.android.tuve.recommendVideoList

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.tuve.FeedListFragment
import marshi.android.tuve.di.FragmentScope

@Module
interface RecommendVideoListFragmentModule {
  
  @FragmentScope
  @ContributesAndroidInjector
  fun contributeFeedListFragment(): FeedListFragment
  
}

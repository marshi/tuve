package marshi.android.tuve.ui.recommendVideoList

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.tuve.di.FragmentScope

@Module
interface RecommendVideoListFragmentModule {
  
  @FragmentScope
  @ContributesAndroidInjector
  fun contributeFeedListFragment(): RecommendVideoListFragment
  
}

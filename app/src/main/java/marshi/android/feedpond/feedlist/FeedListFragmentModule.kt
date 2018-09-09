package marshi.android.feedpond.feedlist

import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.feedpond.FeedListFragment
import marshi.android.feedpond.di.FragmentScope

@Module
interface FeedListFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeFeedListFragment(): FeedListFragment

}

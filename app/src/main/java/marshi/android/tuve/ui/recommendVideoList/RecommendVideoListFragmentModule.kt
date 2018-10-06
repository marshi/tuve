package marshi.android.tuve.ui.recommendVideoList

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.tuve.di.FragmentScope

@Module
interface RecommendVideoListFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(
        modules = [
            RecommendVideoListFragmentModuleBuilder::class
        ]
    )
    fun contributeRecommendVideoListFragment(): RecommendVideoListFragment
}

@Module
interface RecommendVideoListFragmentModuleBuilder {

    @FragmentScope
    @Binds
    fun bindsRecommendListFragment(f: RecommendVideoListFragment): Fragment
}

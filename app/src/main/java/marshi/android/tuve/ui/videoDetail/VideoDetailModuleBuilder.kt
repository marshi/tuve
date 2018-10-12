package marshi.android.tuve.ui.videoDetail

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import marshi.android.tuve.di.FragmentScope

@Module
interface VideoDetailModuleBuilder {

  @FragmentScope
  @ContributesAndroidInjector(modules = [VideoDetailFragmentModule::class])
  fun bindsVideoDetailFragment(): VideoDetailFragment
}

@Module
interface VideoDetailFragmentModule {

  @Binds
  fun bindsVideoDetailFragment(f: VideoDetailFragment): Fragment
}

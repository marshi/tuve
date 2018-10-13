package marshi.android.tuve.di

import dagger.Binds
import dagger.Module
import marshi.android.tuve.domain.repository.IFollowRepository
import marshi.android.tuve.repository.database.follow.FollowRepository
import javax.inject.Singleton

@Module
interface RepositoryModule {

  @Binds
  @Singleton
  fun bindsFollowRepository(r: FollowRepository): IFollowRepository

}
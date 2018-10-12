package marshi.android.tuve.repository.database

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import marshi.android.tuve.repository.database.follow.FollowDao
import javax.inject.Singleton

@Module
class DatabaseModule {

  @Provides
  @Singleton
  fun providesDatabase(app: Application): AppDatabase {
    return Room.databaseBuilder(app, AppDatabase::class.java, "tuve_db").build()
  }

  @Provides
  @Singleton
  fun providesFollowDao(database: AppDatabase): FollowDao {
    return database.followDao()
  }
}

package marshi.android.tuve.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import marshi.android.tuve.repository.database.follow.Follow
import marshi.android.tuve.repository.database.follow.FollowDao

@Database(
  entities = [
    Follow::class
  ], version = 1
)
abstract class AppDatabase : RoomDatabase() {
  abstract fun followDao(): FollowDao
}

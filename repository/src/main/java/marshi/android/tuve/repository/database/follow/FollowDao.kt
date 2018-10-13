package marshi.android.tuve.repository.database.follow

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FollowDao {

  @Insert
  fun insert(follow: Follow)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertOrUpdate(follow: Follow)

  @Delete
  fun delete(follow: Follow)

  @Query("select * from follow where channel_id = :channelId")
  fun query(channelId: String): Follow?
}

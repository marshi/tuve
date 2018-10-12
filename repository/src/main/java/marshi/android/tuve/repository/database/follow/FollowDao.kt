package marshi.android.tuve.repository.database.follow

import androidx.room.Dao
import androidx.room.Insert
import marshi.android.tuve.repository.database.follow.Follow

@Dao
interface FollowDao {

    @Insert
    fun insert(follow: Follow)
}

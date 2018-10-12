package marshi.android.tuve.repository.database.dao

import androidx.room.Dao
import androidx.room.Insert
import marshi.android.tuve.repository.database.entity.Follow

@Dao
interface FollowDao {

    @Insert
    fun insert(follow: Follow)
}

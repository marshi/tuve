package marshi.android.tuve.repository.database.follow

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import marshi.android.tuve.domain.entity.FollowEntity

@Entity
class Follow(
  @PrimaryKey @ColumnInfo(name = "channel_id") val channelId: String
) {
  companion object {
    fun from(entity: FollowEntity): Follow {
      return Follow(entity.channelId.id)
    }
  }
}

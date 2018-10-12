package marshi.android.tuve.repository.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Follow(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "channel_id") val channelId: String
)

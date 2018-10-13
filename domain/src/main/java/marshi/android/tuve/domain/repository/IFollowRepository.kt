package marshi.android.tuve.domain.repository

import io.reactivex.Single
import marshi.android.tuve.domain.entity.ChannelId
import marshi.android.tuve.domain.valueobject.FollowStatus

interface IFollowRepository {

  fun followStatus(channelId: ChannelId): Single<FollowStatus>
  fun delete(channelId: ChannelId): Single<Unit>
  fun insertOrUpdate(channelId: ChannelId): Single<Unit>
}

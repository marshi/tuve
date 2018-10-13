package marshi.android.tuve.domain.usecase

import io.reactivex.Single
import marshi.android.tuve.domain.entity.ChannelId
import marshi.android.tuve.domain.repository.IFollowRepository
import marshi.android.tuve.domain.valueobject.FollowStatus
import javax.inject.Inject

class FollowUseCase @Inject constructor(
  private val repositoy: IFollowRepository
) {

  fun follow(channelId: ChannelId): Single<FollowStatus> {
    return repositoy.insertOrUpdate(channelId).flatMap {
      fetchFollowStatus(channelId)
    }
  }

  fun unfollow(channelId: ChannelId): Single<FollowStatus> {
    return repositoy.delete(channelId).flatMap {
      fetchFollowStatus(channelId)
    }
  }

  fun fetchFollowStatus(channelId: ChannelId): Single<FollowStatus> {
    return repositoy.followStatus(channelId)
  }
}

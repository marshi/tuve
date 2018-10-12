package marshi.android.tuve.ui.videoDetail

import androidx.lifecycle.MutableLiveData
import marshi.android.tuve.di.FragmentScope
import marshi.android.tuve.domain.ChannelId
import marshi.android.tuve.domain.FollowStatus
import marshi.android.tuve.repository.database.follow.FollowRepository
import javax.inject.Inject

@FragmentScope
class VideoDescriptionItemViewModel @Inject constructor(
  private val followRepository: FollowRepository
) {

  val followStatus = MutableLiveData<FollowStatus>()

  fun hadFollowed(channelId: ChannelId) {
    if (followStatus.value == null) {
      followStatus.value = FollowStatus.NotFollow
      return
    }
    if (followStatus.value == FollowStatus.NotFollow) {
      followStatus.value = FollowStatus.AlreadyFollowed
    } else {
      followStatus.value = FollowStatus.NotFollow
    }
  }
}

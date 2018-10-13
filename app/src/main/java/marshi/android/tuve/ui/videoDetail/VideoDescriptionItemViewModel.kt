package marshi.android.tuve.ui.videoDetail

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import marshi.android.tuve.di.FragmentScope
import marshi.android.tuve.domain.ChannelId
import marshi.android.tuve.domain.FollowEntity
import marshi.android.tuve.domain.FollowStatus
import marshi.android.tuve.repository.database.follow.FollowRepository
import javax.inject.Inject

@FragmentScope
class VideoDescriptionItemViewModel @Inject constructor(
  private val followRepository: FollowRepository
) {

  val followStatus = MutableLiveData<FollowStatus>()

  @SuppressLint("CheckResult")
  fun follow(channelId: ChannelId) {
    val followEntity = FollowEntity(channelId)
    followRepository.insertOrUpdate(followEntity).subscribeBy {
      updateToLatestFollowStatus(channelId)
    }
  }

  @SuppressLint("CheckResult")
  fun unfollow(channelId: ChannelId) {
    val followEntity = FollowEntity(channelId)
    followRepository.delete(followEntity).subscribeBy {
      updateToLatestFollowStatus(channelId)
    }
  }

  @SuppressLint("CheckResult")
  fun updateToLatestFollowStatus(channelId: ChannelId) {
    followRepository.followStatus(channelId)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe {it ->
        followStatus.value = it
      }
  }
}

package marshi.android.tuve.ui.videoDetail

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import marshi.android.tuve.di.FragmentScope
import marshi.android.tuve.domain.entity.ChannelId
import marshi.android.tuve.domain.usecase.FollowUseCase
import marshi.android.tuve.domain.valueobject.FollowStatus
import javax.inject.Inject

@FragmentScope
class VideoDescriptionItemViewModel @Inject constructor(
  private val useCase: FollowUseCase
) {

  val followStatus = MutableLiveData<FollowStatus>()

  @SuppressLint("CheckResult")
  fun follow(channelId: ChannelId) {
    useCase.follow(channelId)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe { it ->
        followStatus.value = it
      }
  }

  @SuppressLint("CheckResult")
  fun unfollow(channelId: ChannelId) {
    useCase.unfollow(channelId)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe { it ->
        followStatus.value = it
      }
  }

  @SuppressLint("CheckResult")
  fun updateToLatestFollowStatus(channelId: ChannelId) {
    useCase.fetchFollowStatus(channelId)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe { it ->
        followStatus.value = it
      }
  }
}

package marshi.android.tuve.ui.videoDetail

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import marshi.android.tuve.domain.entity.ChannelId
import marshi.android.tuve.domain.entity.VideoSnippetEntity
import marshi.android.tuve.repository.api.youtube.YoutubeRepository
import javax.inject.Inject

class VideoDetailBottomListViewModel @Inject constructor(
  private val youtubeRepository: YoutubeRepository
) {

  val videoSnippetEntities = MutableLiveData<List<VideoSnippetEntity>>()

  @SuppressLint("CheckResult")
  fun channel(channelId: ChannelId) {
    youtubeRepository.search(channelId)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeBy(
        onSuccess = {
          videoSnippetEntities.value = it
        },
        onError = {
          println(it)
        }
      )
  }
}

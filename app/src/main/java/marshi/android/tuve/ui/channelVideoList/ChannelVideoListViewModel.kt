package marshi.android.tuve.ui.channelVideoList

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import marshi.android.tuve.domain.ChannelId
import marshi.android.tuve.domain.VideoSnippetEntity
import marshi.android.tuve.repository.youtube.YoutubeRepository
import javax.inject.Inject

internal class ChannelVideoListViewModel @Inject constructor(
  private val repository: YoutubeRepository
) : ViewModel() {
  
  val items: MutableLiveData<List<VideoSnippetEntity>> = MutableLiveData()
  
  @SuppressLint("CheckResult")
  fun update(channelId: ChannelId) {
    items.value = mutableListOf()
    repository
      .search(channelId)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(
        { items.value = it },
        { println(it) }
      )
  }
  
}

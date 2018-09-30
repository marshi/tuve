package marshi.android.tuve.feed_media_list

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import marshi.android.tuve.domain.VideoSnippet
import marshi.android.tuve.repository.youtube.YoutubeRepository
import javax.inject.Inject

class FeedMediaListViewModel @Inject constructor(
  private val repository: YoutubeRepository
) : ViewModel() {
  
  val items: MutableLiveData<List<VideoSnippet>> = MutableLiveData()
  
  @SuppressLint("CheckResult")
  fun update(query: String) {
    items.value = mutableListOf()
    repository
      .search(query)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(
        { items.value = it },
        { println(it) }
      )
  }
  
}
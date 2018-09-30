package marshi.android.tuve.feed_media_list

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import marshi.android.tuve.domain.FeedMediaEntity
import marshi.android.tuve.repository.feedly.FeedlyRepository
import javax.inject.Inject

class FeedMediaListViewModel @Inject constructor(
  private val repository: FeedlyRepository
) : ViewModel() {
  
  val items: MutableLiveData<List<FeedMediaEntity>> = MutableLiveData()
  
  @SuppressLint("CheckResult")
  fun update(query: String) {
    items.value = mutableListOf()
    repository
      .search(query)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(
        { items.value = it },
        { throw it }
      )
  }
  
}

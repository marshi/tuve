package marshi.android.feedpond.repository.feedly

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FeedlyRepository @Inject constructor(
  val api: FeedlyApiClient
) {
  fun search(): Single<String?> {
    return api.search("query").subscribeOn(Schedulers.io()).map { it.scheme }
  }
}
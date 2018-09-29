package marshi.android.feedpond.repository.feedly

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import marshi.android.feedpond.domain.FeedMediaEntity
import javax.inject.Inject

class FeedlyRepository @Inject constructor(
  val api: FeedlyApiClient
) {
  fun search(query: String): Single<List<FeedMediaEntity>> {
    return api.search(query)
      .subscribeOn(Schedulers.io())
      .map { it.results.map { it.convert() } }}
}

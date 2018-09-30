package marshi.android.tuve.repository.feedly

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import marshi.android.tuve.domain.FeedMediaEntity
import javax.inject.Inject

class FeedlyRepository @Inject constructor(
  private val api: FeedlyApiClient
) {
  fun search(query: String): Single<List<FeedMediaEntity>> {
    return api.search(query, 20)
      .subscribeOn(Schedulers.io())
      .map { it.results.map { it.convert() } }}
}

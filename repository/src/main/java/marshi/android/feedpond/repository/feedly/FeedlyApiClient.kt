package marshi.android.feedpond.repository.feedly

import io.reactivex.Single
import marshi.android.feedpond.repository.feedly.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedlyApiClient {
  
  @GET("/v3/search/feeds")
  fun search(@Query("query") query: String): Single<SearchResponse>
  
}

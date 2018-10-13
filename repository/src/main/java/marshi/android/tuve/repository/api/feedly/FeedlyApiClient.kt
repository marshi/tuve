package marshi.android.tuve.repository.api.feedly

import io.reactivex.Single
import marshi.android.tuve.repository.api.feedly.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedlyApiClient {
  
  @GET("/v3/search/feeds")
  fun search(
    @Query("query") query: String,
    @Query("count") count: Int
  ): Single<SearchResponse>
  
}

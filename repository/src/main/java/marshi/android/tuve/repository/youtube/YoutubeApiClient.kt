package marshi.android.tuve.repository.youtube

import io.reactivex.Single
import marshi.android.tuve.repository.youtube.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApiClient {
  
  @GET("/youtube/v3/search")
  fun search(
    @Query("part") part: String,
    @Query("channelId") channelId: String?,
    @Query("order") order: String?,
    @Query("key") key: String,
    @Query("maxResults") limit: Int
  ): Single<SearchResponse>
}

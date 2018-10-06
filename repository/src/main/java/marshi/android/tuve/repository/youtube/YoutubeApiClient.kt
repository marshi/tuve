package marshi.android.tuve.repository.youtube

import io.reactivex.Single
import marshi.android.tuve.repository.youtube.response.YoutubeResponse
import marshi.android.tuve.repository.youtube.response.YoutubeVideoResponse
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
  ): Single<YoutubeResponse>

  @GET("/youtube/v3/videos")
  fun videoDetail(
    @Query("part") part: String,
    @Query("id") videoId: String,
    @Query("key") key: String
  ): Single<YoutubeVideoResponse>
}

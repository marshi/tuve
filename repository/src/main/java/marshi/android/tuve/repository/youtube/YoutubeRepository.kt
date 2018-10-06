package marshi.android.tuve.repository.youtube

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import marshi.android.tuve.domain.RecommendVideoSnippetEntity
import marshi.android.tuve.domain.VideoSnippetEntity
import javax.inject.Inject

class YoutubeRepository @Inject constructor(
  private val api: YoutubeApiClient,
  private val key: YoutubeApiKey
) {
  fun search(channelId: String): Single<List<VideoSnippetEntity>> {
    return api.search(
      part = "snippet",
      channelId = "UCD-miitqNY3nyukJ4Fnf4_A",
      order = "date",
      key = key.value,
      limit = 10
    ).subscribeOn(Schedulers.io())
      .map { it.convert() }
  }

  fun recommend(channelId: String): Single<List<RecommendVideoSnippetEntity>> {
    return api.search(
      part = "snippet",
      channelId = "UCD-miitqNY3nyukJ4Fnf4_A",
      order = "date",
      key = key.value,
      limit = 10
    ).subscribeOn(Schedulers.io())
      .map { it.convertToRecommend() }
  }
}

package marshi.android.tuve.repository.api.youtube

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import marshi.android.tuve.domain.entity.ChannelId
import marshi.android.tuve.domain.entity.RecommendVideoSnippetEntity
import marshi.android.tuve.domain.entity.VideoDetailEntity
import marshi.android.tuve.domain.entity.VideoId
import marshi.android.tuve.domain.entity.VideoSnippetEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class YoutubeRepository @Inject constructor(
        private val api: YoutubeApiClient,
        private val key: YoutubeApiKey
) {
  fun search(channelId: ChannelId): Single<List<VideoSnippetEntity>> {
    return api.search(
      part = "snippet,id",
      channelId = "UCD-miitqNY3nyukJ4Fnf4_A",
      order = "date",
      key = key.value,
      limit = 10
    ).subscribeOn(Schedulers.io())
      .map { it.convert() }
  }

  fun recommend(channelId: ChannelId): Single<List<RecommendVideoSnippetEntity>> {
    return api.search(
      part = "snippet,id",
      channelId = "UCD-miitqNY3nyukJ4Fnf4_A",
      order = "date",
      key = key.value,
      limit = 10
    ).subscribeOn(Schedulers.io())
      .map { it.convertToRecommend() }
  }

  fun videoDetail(videoId: VideoId): Single<VideoDetailEntity> {
    return api.videoDetail(
      part = "player",
      videoId = videoId.id,
      key = key.value
    ).subscribeOn(Schedulers.io())
      .map { it.convertToVideoDetail() }
  }
}

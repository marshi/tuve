package marshi.android.tuve.domain.entity

import java.util.Date

class RecommendVideoSnippetEntity(
  val videoId: VideoId,
  val publishedAt: Date,
  val channelId: ChannelId,
  val title: String,
  val description: String,
  val thumbnail: VideoThumbnail,
  val channelTitle: String,
  val liveBroadcastContent: String
)

package marshi.android.tuve.domain

class VideoSnippetEntity(
  val publishedAt: String,
  val channelId: String,
  val title: String,
  val description: String,
  val thumbnail: VideoThumbnail,
  val channelTitle: String,
  val liveBroadcastContent: String
)

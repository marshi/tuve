package marshi.android.tuve.domain

class VideoSnippet(
  val publishedAt: String,
  val channelId: String,
  val title: String,
  val description: String,
  val thumbnails: VideoThumbnail,
  val channelTitle: String,
  val liveBroadcastContent: String
)

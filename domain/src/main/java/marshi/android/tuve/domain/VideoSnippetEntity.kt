package marshi.android.tuve.domain

import marshi.android.tuve.ext.humanReadableRelativeText
import java.util.Date

class VideoSnippetEntity(
    val videoId: VideoId,
    val publishedAt: Date,
    val channelId: ChannelId,
    val title: String,
    val description: String,
    val thumbnail: VideoThumbnail,
    val channelTitle: String,
    val liveBroadcastContent: String
) {
    val humanReadableRelativeText = publishedAt.humanReadableRelativeText()
}

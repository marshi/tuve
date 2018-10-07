package marshi.android.tuve.domain

import marshi.android.tuve.ext.humanReadableRelativeText
import java.util.Date

class VideoSnippetEntity(
    val publishedAt: Date,
    val channelId: String,
    val title: String,
    val description: String,
    val thumbnail: VideoThumbnail,
    val channelTitle: String,
    val liveBroadcastContent: String
) {
    val humanReadableRelativeText = publishedAt.humanReadableRelativeText()
}

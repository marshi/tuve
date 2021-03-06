package marshi.android.tuve.repository.api.youtube.response

import marshi.android.tuve.domain.entity.VideoDetailEntity
import marshi.android.tuve.domain.entity.VideoId

class YoutubeVideoResponse(
        val etag: String,
        val nextPageToken: String?,
        val regionCode: String?,
        val pageInfo: PageInfo,
        val items: List<VideoItem>
) {
    fun convertToVideoDetail(): VideoDetailEntity? {
        val item = items.firstOrNull() ?: return null
        return VideoDetailEntity(
          VideoId(item.id),
          item.player!!.embedHtml
        )
    }
}

class VideoItem(
        val kind: String,
        val etag: String,
        val id: String,
        val snippet: SnippetResponse?,
        val player: PlayerResponse?
)

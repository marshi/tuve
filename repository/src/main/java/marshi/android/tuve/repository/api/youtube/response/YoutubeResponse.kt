package marshi.android.tuve.repository.api.youtube.response

import marshi.android.tuve.domain.entity.ChannelId
import marshi.android.tuve.domain.entity.RecommendVideoSnippetEntity
import marshi.android.tuve.domain.entity.VideoId
import marshi.android.tuve.domain.entity.VideoSnippetEntity
import marshi.android.tuve.ext.toDate

class YoutubeResponse(
        val etag: String,
        val nextPageToken: String?,
        val regionCode: String?,
        val pageInfo: PageInfo,
        val items: List<ChannelItem>
) {

    fun convert(): List<VideoSnippetEntity> {
        return items.asSequence()
            .mapNotNull {
                it.snippet?.let { snippet ->
                  VideoSnippetEntity(
                    VideoId(it.id.videoId),
                    snippet.publishedAt.toDate(),
                    ChannelId(snippet.channelId),
                    snippet.title,
                    snippet.description,
                    snippet.thumbnails.high.convert(),
                    snippet.channelTitle,
                    snippet.liveBroadcastContent
                  )
                }
            }.toList()
    }

    fun convertToRecommend(): List<RecommendVideoSnippetEntity> {
        return items.mapNotNull {
            it.snippet?.let { snippet ->
              RecommendVideoSnippetEntity(
                VideoId(it.id.videoId),
                snippet.publishedAt.toDate(),
                ChannelId(snippet.channelId),
                snippet.title,
                snippet.description,
                snippet.thumbnails.high.convert(),
                snippet.channelTitle,
                snippet.liveBroadcastContent
              )
            }
        }
    }
}

class ChannelItem(
        val kind: String,
        val etag: String,
        val id: Id,
        val snippet: SnippetResponse?,
        val player: PlayerResponse?
)

class Id(
    val kind: String,
    val videoId: String
)

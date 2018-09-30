package marshi.android.tuve.repository.youtube.response

import marshi.android.tuve.domain.VideoSnippet
import marshi.android.tuve.domain.VideoThumbnail
import java.net.URL

class SearchResponse(
  val etag: String,
  val nextPageToken: String,
  val regionCode: String,
  val pageInfo: PageInfo,
  val items: List<Item>
) {
  fun convert(): List<VideoSnippet> {
    return items.map {
      it.snippet.let { snippet ->
        VideoSnippet(
          snippet.publishedAt,
          snippet.channelId,
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

class PageInfo(
  val tokenResults: Int,
  val resultsPerPage: Int
)

class Item(
  val kind: String,
  val etag: String,
  val id: Id,
  val snippet: Snippet
)

class Id(
  val king: String,
  val videoId: String
)

class Snippet(
  val publishedAt: String,
  val channelId: String,
  val title: String,
  val description: String,
  val thumbnails: Thumbnails,
  val channelTitle: String,
  val liveBroadcastContent: String
)

class Thumbnails(
  val default: Thumbnail,
  val medium: Thumbnail,
  val high: Thumbnail
)

class Thumbnail(
  val url: String,
  val width: Int,
  val height: Int
) {
  fun convert(): VideoThumbnail =
    VideoThumbnail(
      URL(url), width, height
    )
}

package marshi.android.tuve.repository.api.youtube.response

import marshi.android.tuve.domain.VideoThumbnail
import java.net.URL

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

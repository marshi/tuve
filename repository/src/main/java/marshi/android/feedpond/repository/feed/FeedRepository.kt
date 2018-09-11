package marshi.android.feedpond.repository.feed

import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import marshi.android.feedpond.domain.FeedItemEntity
import java.net.URL
import javax.inject.Inject

class FeedRepository @Inject constructor() {

    fun feed() : List<FeedItemEntity> {
        val url = "https://stackoverflow.com/feeds/tag?tagnames=rome"
        val feed = SyndFeedInput().build(XmlReader(URL(url)))
        val mediaTitle = feed.title
        return feed.entries.map {
            FeedItemEntity(mediaTitle, it.title, it.contents.first().value)
        }
    }

}

package marshi.android.feedpond.repository.feed

import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import marshi.android.feedpond.domain.FeedItemEntity
import marshi.android.feedpond.ext.decodeNCR
import java.net.URI
import java.net.URL
import javax.inject.Inject

class FeedRepository @Inject constructor() {
  
  fun feed(): Single<List<FeedItemEntity>> {
    val url = "https://postd.cc/feed/atom/"
//        val url = "https://stackoverflow.com/feeds/tag?tagnames=rome"
    return Single
      .create<SyndFeed> {
        it.onSuccess(SyndFeedInput().build(XmlReader(URL(url))))
      }.subscribeOn(Schedulers.io())
      .observeOn(Schedulers.computation())
      .map {
        val mediaTitle = it.title
        it.entries.map {
          FeedItemEntity(
            mediaTitle.decodeNCR(),
            it.title.decodeNCR(),
            it.description.value.decodeNCR(),
            URI.create(it.uri)
          )
        }
      }
  }
}

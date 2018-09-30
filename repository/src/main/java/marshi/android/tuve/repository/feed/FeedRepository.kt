package marshi.android.tuve.repository.feed

import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import marshi.android.tuve.domain.FeedEntity
import java.net.URL
import javax.inject.Inject

class FeedRepository @Inject constructor() {
  
  fun feed(): Single<List<FeedEntity>> {
    val url = "https://postd.cc/feed/atom/"
//        val url = "https://stackoverflow.com/feeds/tag?tagnames=rome"
    return Single
      .create<SyndFeed> {
        it.onSuccess(SyndFeedInput().build(XmlReader(URL(url))))
      }.subscribeOn(Schedulers.io())
      .observeOn(Schedulers.computation())
      .map { it.convert() }
  }
}
package marshi.android.tuve.repository.feed

import com.rometools.rome.feed.synd.SyndFeed
import marshi.android.tuve.domain.FeedEntity
import marshi.android.tuve.ext.decodeNCR
import java.net.URI

fun SyndFeed.convert(): List<FeedEntity> {
  return entries.map {
    FeedEntity(
      title.decodeNCR(),
      it.title.decodeNCR(),
      it.description.value.decodeNCR(),
      URI.create(it.uri)
    )
  }
}

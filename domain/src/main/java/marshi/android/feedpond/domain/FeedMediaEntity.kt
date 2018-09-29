package marshi.android.feedpond.domain

import java.net.URI

/**
 * 記事を配信しているメディア.
 */
data class FeedMediaEntity(
  val feedId: String,
  val title: String,
  val description: String?,
  val uri: URI,
  val iconUrl: URI?
)

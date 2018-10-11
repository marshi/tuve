package marshi.android.tuve.repository.api.feedly.response

import marshi.android.tuve.domain.FeedMediaEntity
import java.net.URI

class SearchResponse(
        val results: List<Result>,
        val scheme: String
)

class Result(
  val feedId: String,
  val title: String,
  val lastUpdated: Long,
  val subscribers: Int,
  val score: Double,
  val coverage: Double,
  val coverageScore: Double,
  val estimatedEngagement: Int,
  val velocity: Double,
  val website: String,
  val language: String,
  val contentType: String,
  val description: String?,
  val coverUrl: String,
  val iconUrl: String?,
  val partial: Boolean,
  val visualUrl: String?,
  val coverColor: String?,
  val twitterScreenName: String?,
  val twitterFollowers: Int?,
  val art: Double
) {
  fun convert(): FeedMediaEntity = FeedMediaEntity(
    title,
    title,
    description,
    URI(website),
    iconUrl?.let { URI(it) }
  )
}

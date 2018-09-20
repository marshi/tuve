package marshi.android.feedpond.repository.feedly.response

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
  val coverage: Int,
  val coverageScore: Int,
  val estimatedEngagement: Int,
  val velocity: Double,
  val website: String,
  val language: String,
  val contentType: String,
  val description: String,
  val coverUrl: String,
  val iconUrl: String,
  val partial: Boolean,
  val visualUrl: String,
  val coverColor: String,
  val twitterScreenName: String,
  val twitterFollowers: Int,
  val art: String
)

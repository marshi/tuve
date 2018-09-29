package marshi.android.feedpond.domain

import java.net.URI

/**
 * 特定フィードの記事サマリー
 */
data class FeedEntity(
        val mediaTitle: String,
        val title: String,
        val description: String?,
        val uri: URI
)

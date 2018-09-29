package marshi.android.feedpond.feed_media_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import marshi.android.feedpond.R
import marshi.android.feedpond.databinding.ActivityFeedMediaListBinding
import marshi.android.feedpond.domain.FeedMediaEntity
import java.net.URI

class FeedMediaListActivity : AppCompatActivity() {
  
  lateinit var binding: ActivityFeedMediaListBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_feed_media_list)
    val adapter = FeedMediaAdapter()
    binding.recyclerView.layoutManager = LinearLayoutManager(this)
    binding.recyclerView.adapter = adapter
    adapter.add(FeedMediaEntity("feedid", "title", "dessss", URI.create(""), URI.create("")))
  }
}

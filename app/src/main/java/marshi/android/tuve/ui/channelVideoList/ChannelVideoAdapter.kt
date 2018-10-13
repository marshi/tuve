package marshi.android.tuve.ui.channelVideoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import marshi.android.tuve.R
import marshi.android.tuve.databinding.FeedMediaItemBinding
import marshi.android.tuve.domain.entity.VideoSnippetEntity
import javax.inject.Inject

class ChannelVideoAdapter @Inject constructor()
  : RecyclerView.Adapter<FeedMediaViewHolder>() {
  
  private val items = mutableListOf<VideoSnippetEntity>()
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedMediaViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_media_item, parent, false)
    return FeedMediaViewHolder(view)
  }
  
  override fun getItemCount() = items.size
  
  override fun onBindViewHolder(holder: FeedMediaViewHolder, position: Int) {
    val binding = holder.binding
    binding.vm = ChannelVideoViewModel(items[position])
  }
  
  fun clear() {
    items.removeAll { true }
    notifyDataSetChanged()
  }
  
  fun add(entity: VideoSnippetEntity) {
    val size = items.size
    items.add(entity)
    notifyItemInserted(size)
  }
}

class FeedMediaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val binding = FeedMediaItemBinding.bind(itemView)!!
}

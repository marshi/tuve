package marshi.android.feedpond.feed_media_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import marshi.android.feedpond.R
import marshi.android.feedpond.databinding.FeedMediaItemBinding
import marshi.android.feedpond.domain.FeedMediaEntity
import javax.inject.Inject

class FeedMediaAdapter @Inject constructor()
  : RecyclerView.Adapter<FeedMediaViewHolder>() {
  
  private val items = mutableListOf<FeedMediaEntity>()
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedMediaViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_media_item, parent, false)
    return FeedMediaViewHolder(view)
  }
  
  override fun getItemCount() = items.size
  
  override fun onBindViewHolder(holder: FeedMediaViewHolder, position: Int) {
    val binding = holder.binding
    binding.vm = FeedMediaViewModel(items[position])
  }
  
  fun clear() {
    items.removeAll { true }
    notifyDataSetChanged()
  }
  
  fun add(entity: FeedMediaEntity) {
    val size = items.size
    items.add(entity)
    notifyItemInserted(size)
  }
}

class FeedMediaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val binding = FeedMediaItemBinding.bind(itemView)!!
}

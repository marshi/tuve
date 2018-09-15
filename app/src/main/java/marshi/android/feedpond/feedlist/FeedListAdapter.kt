package marshi.android.feedpond.feedlist

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import marshi.android.feedpond.databinding.FeedItemBinding
import marshi.android.feedpond.domain.FeedItemEntity

class FeedListAdapter : RecyclerView.Adapter<FeedItemHolder>() {
  
  private val items = mutableListOf<FeedItemEntity>()
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemHolder {
    val binding = FeedItemBinding.inflate(LayoutInflater.from(parent.context))
    return FeedItemHolder(binding.root)
  }
  
  override fun getItemCount() = items.size
  
  override fun onBindViewHolder(holder: FeedItemHolder, position: Int) {
    val entity = items[position]
    holder.binding?.apply {
      title.text = entity.title
      article.text = entity.description
    }
  }
  
  fun addAll(list: List<FeedItemEntity>) {
    items.addAll(list)
    notifyDataSetChanged()
  }
  
  fun add(item: FeedItemEntity) {
    items.add(item)
    notifyItemInserted(items.indexOf(item))
  }
  
}


class FeedItemHolder(v: View) : RecyclerView.ViewHolder(v) {
  
  var binding: FeedItemBinding? = null
    private set
  
  init {
    binding = DataBindingUtil.bind(v)
  }
  
}
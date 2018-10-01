package marshi.android.tuve.recommendVideoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import marshi.android.tuve.R
import marshi.android.tuve.databinding.FeedItemBinding
import marshi.android.tuve.domain.FeedEntity

class RecommendVideoListAdapter : RecyclerView.Adapter<FeedItemHolder>() {
  
  private val items = mutableListOf<FeedEntity>()
  
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
      root.setOnClickListener {
        val bundle = bundleOf(
          "uri" to entity.uri,
          "title" to entity.title
        )
        Navigation.findNavController(it).navigate(R.id.feed_detail_fragment, bundle)
      }
    }
  }
  
  fun addAll(list: List<FeedEntity>) {
    items.addAll(list)
    notifyDataSetChanged()
  }
  
  fun add(media: FeedEntity) {
    items.add(media)
    notifyItemInserted(items.indexOf(media))
  }
  
}

class FeedItemHolder(v: View) : RecyclerView.ViewHolder(v) {
  
  var binding: FeedItemBinding? = null
    private set
  
  init {
    binding = DataBindingUtil.bind(v)
  }
  
}
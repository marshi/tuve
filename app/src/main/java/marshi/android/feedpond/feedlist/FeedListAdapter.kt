package marshi.android.feedpond.feedlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import marshi.android.feedpond.domain.FeedItemEntity
import marshi.android.feedpond.databinding.FeedItemBinding

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
            article.text = entity.article
        }
    }

    fun add(item: FeedItemEntity) {
        items.add(item)
    }
}


class FeedItemHolder(v: View) : RecyclerView.ViewHolder(v) {

    var binding: FeedItemBinding? = null
        private set

    init {
        binding = DataBindingUtil.bind(v)
    }

}

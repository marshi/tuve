package marshi.android.tuve.ui.recommendVideoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import marshi.android.tuve.R
import marshi.android.tuve.databinding.FeedItemBinding
import marshi.android.tuve.domain.VideoSnippetEntity

class RecommendVideoListAdapter : RecyclerView.Adapter<RecommendVideoItemHolder>() {

    private val items = mutableListOf<VideoSnippetEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendVideoItemHolder {
        val binding = FeedItemBinding.inflate(LayoutInflater.from(parent.context))
        return RecommendVideoItemHolder(binding.root)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecommendVideoItemHolder, position: Int) {
        val entity = items[position]
        holder.binding?.apply {
            title.text = entity.title
            article.text = entity.description
            root.setOnClickListener {
                val bundle = bundleOf(
                    "uri" to "",
                    "title" to entity.title
                )
                Navigation.findNavController(it).navigate(R.id.feed_detail_fragment, bundle)
            }
        }
    }

    fun addAll(list: List<VideoSnippetEntity>) {
        items.addAll(list)
        notifyDataSetChanged()
    }
}

class RecommendVideoItemHolder(v: View) : RecyclerView.ViewHolder(v) {

    var binding: FeedItemBinding? = null
        private set

    init {
        binding = DataBindingUtil.bind(v)
    }
}

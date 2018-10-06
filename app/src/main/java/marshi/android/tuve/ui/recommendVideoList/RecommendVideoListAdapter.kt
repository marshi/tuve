package marshi.android.tuve.ui.recommendVideoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import marshi.android.tuve.R
import marshi.android.tuve.databinding.RecommendVideoItemBinding
import marshi.android.tuve.domain.RecommendVideoSnippetEntity

class RecommendVideoListAdapter : RecyclerView.Adapter<RecommendVideoItemHolder>() {

    private val items = mutableListOf<RecommendVideoSnippetEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendVideoItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommend_video_item, parent, false)
        return RecommendVideoItemHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecommendVideoItemHolder, position: Int) {
        val entity = items[position]
        holder.binding.vm?.update(entity)
        holder.binding.root.setOnClickListener {
            val bundle = bundleOf(
                "uri" to "",
                "title" to entity.title
            )
            Navigation.findNavController(it).navigate(R.id.feed_detail_fragment, bundle)
        }
    }

    fun addAll(list: List<RecommendVideoSnippetEntity>) {
        items.addAll(list)
        notifyDataSetChanged()
    }
}

class RecommendVideoItemHolder(v: View) : RecyclerView.ViewHolder(v) {

    val binding: RecommendVideoItemBinding = RecommendVideoItemBinding.bind(v)

    init {
        val viewModel = RecommendVideoViewModel()
        binding.vm = viewModel
    }
}

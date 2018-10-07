package marshi.android.tuve.ui.recommendVideoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import marshi.android.tuve.R
import marshi.android.tuve.databinding.RecommendVideoItemBinding
import marshi.android.tuve.domain.RecommendVideoSnippetEntity
import marshi.android.tuve.ui.videoDetail.VideoDetailFragment
import javax.inject.Inject
import javax.inject.Provider

class RecommendVideoListAdapter @Inject constructor(
    private val fragment: Fragment
) : RecyclerView.Adapter<RecommendVideoItemHolder>(),
    LifecycleObserver {

    private val items = mutableListOf<RecommendVideoSnippetEntity>()
    @Inject internal lateinit var recommendVideoViewModelProvider: Provider<RecommendVideoViewModel>
    internal lateinit var clickListener: ItemOnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendVideoItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommend_video_item, parent, false)
        return RecommendVideoItemHolder(view, recommendVideoViewModelProvider)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecommendVideoItemHolder, position: Int) {
        val entity = items[position]
        val vm = holder.binding.vm!!
        vm.update(entity)
        holder.binding.root.setOnClickListener {
            val bundle = bundleOf(
                VideoDetailFragment.VIDEO_ID to entity.videoId.id
            )
            Navigation.findNavController(holder.binding.root)
                .navigate(R.id.video_detail_fragment, bundle)
        }
    }

    fun addAll(list: List<RecommendVideoSnippetEntity>) {
        items.addAll(list)
        notifyDataSetChanged()
    }
}

class RecommendVideoItemHolder(
    v: View,
    provider: Provider<RecommendVideoViewModel>
) : RecyclerView.ViewHolder(v) {

    val binding: RecommendVideoItemBinding = RecommendVideoItemBinding.bind(v)
    internal val vm = lazy { binding.vm }

    init {
        binding.vm = provider.get()
    }
}

interface ItemOnClickListener {
    fun onClick(recommendVideoViewModel: RecommendVideoViewModel)
}

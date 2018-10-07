package marshi.android.tuve.ui.channelSnippetList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import marshi.android.tuve.R
import marshi.android.tuve.databinding.VideoDetailBottomListItemBinding
import marshi.android.tuve.domain.VideoSnippetEntity
import javax.inject.Inject
import javax.inject.Provider

class ChannelVideoSnippetListAdapter @Inject constructor(
    private val provider: Provider<ChannelVideoSnippetItemViewModel>
) : RecyclerView.Adapter<ViewHolder>() {

    private val list = mutableListOf<VideoSnippetEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_detail_bottom_list_item, parent, false)
        return ViewHolder(view, provider)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = list[position]
        holder.viewModel.update(entity)
    }

    fun addAll(entities: List<VideoSnippetEntity>) {
        val size = list.size
        list.addAll(entities)
        notifyItemRangeInserted(size, entities.size)
    }
}

class ViewHolder(view: View, provider: Provider<ChannelVideoSnippetItemViewModel>) : RecyclerView.ViewHolder(view) {
    val binding = VideoDetailBottomListItemBinding.bind(view)!!
    val viewModel = provider.get()!!
    init {
        binding.vm = viewModel
    }
}

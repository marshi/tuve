package marshi.android.tuve.ui.videoDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import marshi.android.tuve.R
import marshi.android.tuve.databinding.VideoDetailBottomListItemBinding
import marshi.android.tuve.domain.VideoSnippetEntity

class VideoDetailBottomListAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val list = mutableListOf<VideoSnippetEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_detail_bottom_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.binding.vm = VideoDetailBottomListViewModel()
        holder.binding.text.text = "aiueo"
    }

    fun addAll(entities: List<VideoSnippetEntity>) {
        val size = list.size
        list.addAll(entities)
        notifyDataSetChanged()
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = VideoDetailBottomListItemBinding.bind(view)
}

package marshi.android.tuve.ui.videoDetail

import android.view.View
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import marshi.android.tuve.domain.entity.VideoSnippetEntity
import javax.inject.Inject

class VideoDetailAdapter @Inject constructor(
        private val videoDetailNestedGroup: VideoDetailNestedGroup
) : GroupAdapter<VideoDetailViewHolder>() {
    init {
        add(videoDetailNestedGroup)
    }

    fun addSnippet(entities: List<VideoSnippetEntity>) {
        videoDetailNestedGroup.channelVideoSnippetListGroup.addAll(entities)
        update(listOf(videoDetailNestedGroup))
    }
}


class VideoDetailViewHolder(view: View) : ViewHolder(view)





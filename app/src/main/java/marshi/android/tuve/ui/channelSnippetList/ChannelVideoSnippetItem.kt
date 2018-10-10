package marshi.android.tuve.ui.channelSnippetList

import com.xwray.groupie.databinding.BindableItem
import marshi.android.tuve.R
import marshi.android.tuve.databinding.VideoDetailBottomListItemBinding
import marshi.android.tuve.domain.VideoSnippetEntity
import marshi.android.tuve.ui.videoDetail.VideoDetailNavigator
import javax.inject.Provider

class ChannelVideoSnippetItem (
        private val entity: VideoSnippetEntity,
        private val viewModel: Provider<ChannelVideoSnippetItemViewModel>,
        private val navigator: VideoDetailNavigator
) : BindableItem<VideoDetailBottomListItemBinding>() {

    override fun getLayout(): Int {
        return R.layout.video_detail_bottom_list_item
    }

    override fun bind(binding: VideoDetailBottomListItemBinding, p1: Int) {
        if (binding.vm == null) {
            binding.vm = viewModel.get()
            binding.root.setOnClickListener {
                navigator.navigate(binding.root, entity.videoId, entity.channelId)
            }
        }
        binding.vm?.update(entity)
    }
}

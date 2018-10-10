package marshi.android.tuve.ui.videoDetail

import com.xwray.groupie.databinding.BindableItem
import marshi.android.tuve.R
import marshi.android.tuve.databinding.VideoDescriptionBinding
import javax.inject.Inject

class VideoDescriptionItem @Inject constructor(): BindableItem<VideoDescriptionBinding>() {
    override fun getLayout() = R.layout.video_description

    override fun bind(binding: VideoDescriptionBinding, p1: Int) {
    }
}

package marshi.android.tuve.ui.videoDetail

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import marshi.android.tuve.R
import marshi.android.tuve.domain.entity.ChannelId
import marshi.android.tuve.domain.entity.VideoId
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VideoDetailNavigator @Inject constructor() {

    fun navigate(view: View, videoId: VideoId, channelId: ChannelId) {
        val bundle = bundleOf(
            VideoDetailFragment.VIDEO_ID to videoId.id,
            VideoDetailFragment.CHANNEL_ID to channelId.id
        )
        Navigation.findNavController(view)
            .navigate(R.id.video_detail_fragment, bundle)
    }
}
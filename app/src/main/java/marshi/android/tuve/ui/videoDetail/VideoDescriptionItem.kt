package marshi.android.tuve.ui.videoDetail

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.xwray.groupie.databinding.BindableItem
import marshi.android.tuve.R
import marshi.android.tuve.atomic.molecule.updateStatus
import marshi.android.tuve.databinding.VideoDescriptionBinding
import marshi.android.tuve.di.FragmentScope
import marshi.android.tuve.domain.ChannelId
import javax.inject.Inject

@FragmentScope
class VideoDescriptionItem @Inject constructor(
  val fragment: Fragment,
  val vm: VideoDescriptionItemViewModel
) : BindableItem<VideoDescriptionBinding>() {
  override fun getLayout() = R.layout.video_description

  override fun bind(binding: VideoDescriptionBinding, p1: Int) {
    val followButtonBinding = binding.actions.followButtonComponent
    vm.followStatus.observe(fragment, Observer { status ->
      followButtonBinding.updateStatus(status)
    })
    followButtonBinding.followButton.setOnClickListener {
      vm.follow(ChannelId(""))
    }
    followButtonBinding.alreadyFollowButton.setOnClickListener {
      vm.unfollow(ChannelId(""))
    }
    vm.updateToLatestFollowStatus(ChannelId(""))
  }
}

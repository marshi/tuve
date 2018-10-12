package marshi.android.tuve.atomic.molecule

import androidx.core.view.isVisible
import marshi.android.tuve.databinding.FollowButtonBinding
import marshi.android.tuve.domain.FollowStatus

fun FollowButtonBinding.updateStatus(status: FollowStatus) {
  when (status) {
    FollowStatus.AlreadyFollowed -> alreadyFollow()
    FollowStatus.NotFollow -> notFollow()
  }
}

private fun FollowButtonBinding.alreadyFollow() {
  followButton.isVisible = false
  alreadyFollowButton.isVisible = true
}

private fun FollowButtonBinding.notFollow() {
  followButton.isVisible = true
  alreadyFollowButton.isVisible = false
}

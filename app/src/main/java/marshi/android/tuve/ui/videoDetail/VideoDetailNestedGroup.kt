package marshi.android.tuve.ui.videoDetail

import com.xwray.groupie.Group
import com.xwray.groupie.NestedGroup
import marshi.android.tuve.ui.channelSnippetList.ChannelVideoSnippetGroup
import javax.inject.Inject

class VideoDetailNestedGroup @Inject constructor(
        val channelVideoSnippetListGroup: ChannelVideoSnippetGroup
) : NestedGroup() {

    private val list = listOf(
            channelVideoSnippetListGroup
    )

    override fun getGroup(position: Int) = list[position]

    override fun getPosition(group: Group) = list.indexOf(group)

    override fun getGroupCount() = list.size
}

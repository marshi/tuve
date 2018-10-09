package marshi.android.tuve.ui.channelSnippetList

import com.xwray.groupie.Group
import com.xwray.groupie.GroupDataObserver
import com.xwray.groupie.Item
import com.xwray.groupie.databinding.BindableItem
import marshi.android.tuve.databinding.VideoDetailBottomListItemBinding
import marshi.android.tuve.domain.VideoSnippetEntity
import marshi.android.tuve.ui.videoDetail.VideoDetailNavigator
import javax.inject.Inject
import javax.inject.Provider

class ChannelVideoSnippetGroup @Inject constructor(
        private val itemViewModelProvider: Provider<ChannelVideoSnippetItemViewModel>,
        private val navigator: VideoDetailNavigator
) : Group {

    private val list = mutableListOf<BindableItem<VideoDetailBottomListItemBinding>>()
    private var groupDataObserver: GroupDataObserver? = null

    override fun getItemCount() = list.size

    override fun getItem(position: Int) = list[position]

    override fun getPosition(item: Item<*>) = list.indexOf(item)

    override fun registerGroupDataObserver(groupDataObserver: GroupDataObserver) {
        this.groupDataObserver = groupDataObserver
    }

    override fun unregisterGroupDataObserver(groupDataObserver: GroupDataObserver) {
        this.groupDataObserver = null
    }

    fun addAll(entities: List<VideoSnippetEntity>) {
        val bindables = entities.map { ChannelVideoSnippetItem(it, itemViewModelProvider, navigator) }
        list.addAll(bindables)
    }
}
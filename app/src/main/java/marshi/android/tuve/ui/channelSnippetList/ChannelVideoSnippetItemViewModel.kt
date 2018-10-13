package marshi.android.tuve.ui.channelSnippetList

import androidx.lifecycle.MutableLiveData
import marshi.android.tuve.domain.entity.VideoSnippetEntity
import javax.inject.Inject

class ChannelVideoSnippetItemViewModel @Inject constructor(){

    val videoSnippetEntity = MutableLiveData<VideoSnippetEntity>()

    fun update(entity: VideoSnippetEntity) {
        videoSnippetEntity.value = entity
    }
}

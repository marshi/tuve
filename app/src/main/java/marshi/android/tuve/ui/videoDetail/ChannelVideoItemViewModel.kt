package marshi.android.tuve.ui.videoDetail

import androidx.lifecycle.MutableLiveData
import marshi.android.tuve.domain.VideoSnippetEntity
import javax.inject.Inject

class ChannelVideoItemViewModel @Inject constructor(){

    val videoSnippetEntity = MutableLiveData<VideoSnippetEntity>()

    fun update(entity: VideoSnippetEntity) {
        videoSnippetEntity.value = entity
    }
}

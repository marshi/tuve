package marshi.android.tuve.ui.recommendVideoList

import androidx.lifecycle.MutableLiveData
import marshi.android.tuve.domain.VideoSnippetEntity

class RecommendVideoViewModel {

    val videoSnippetEntity = MutableLiveData<VideoSnippetEntity>()

    fun update(entity: VideoSnippetEntity) {
        videoSnippetEntity.value = entity
    }
}

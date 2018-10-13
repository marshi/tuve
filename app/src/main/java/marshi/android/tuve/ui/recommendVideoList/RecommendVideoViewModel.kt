package marshi.android.tuve.ui.recommendVideoList

import androidx.lifecycle.MutableLiveData
import marshi.android.tuve.domain.entity.RecommendVideoSnippetEntity
import marshi.android.tuve.repository.api.youtube.YoutubeRepository
import javax.inject.Inject

class RecommendVideoViewModel @Inject constructor(
    private val repository: YoutubeRepository
) {

    val videoSnippetEntity = MutableLiveData<RecommendVideoSnippetEntity>()

    fun update(entity: RecommendVideoSnippetEntity) {
        videoSnippetEntity.value = entity
    }

}

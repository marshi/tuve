package marshi.android.tuve.ui.recommendVideoList

import androidx.lifecycle.MutableLiveData
import marshi.android.tuve.domain.RecommendVideoSnippetEntity

class RecommendVideoViewModel {

    val videoSnippetEntity = MutableLiveData<RecommendVideoSnippetEntity>()

    fun update(entity: RecommendVideoSnippetEntity) {
        videoSnippetEntity.value = entity
    }
}

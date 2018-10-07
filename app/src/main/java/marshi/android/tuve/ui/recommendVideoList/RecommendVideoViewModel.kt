package marshi.android.tuve.ui.recommendVideoList

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import marshi.android.tuve.domain.RecommendVideoSnippetEntity
import marshi.android.tuve.domain.VideoDetailEntity
import marshi.android.tuve.domain.VideoId
import marshi.android.tuve.repository.youtube.YoutubeRepository
import javax.inject.Inject

class RecommendVideoViewModel @Inject constructor(
    private val repository: YoutubeRepository
) {

    val videoSnippetEntity = MutableLiveData<RecommendVideoSnippetEntity>()

    fun update(entity: RecommendVideoSnippetEntity) {
        videoSnippetEntity.value = entity
    }

}

package marshi.android.tuve.ui.recommendVideoList

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import marshi.android.tuve.domain.VideoSnippetEntity
import marshi.android.tuve.repository.youtube.YoutubeRepository
import javax.inject.Inject

class RecommendVideoListViewModel @Inject constructor(
    private val repository: YoutubeRepository
) {

    val videoSnippetEntityList = MutableLiveData<List<VideoSnippetEntity>>()

    @SuppressLint("CheckResult")
    fun recommendVideoList() {
        repository.search("UCD-miitqNY3nyukJ4Fnf4_A")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { it -> videoSnippetEntityList.value = it },
                onError = {}
            )
    }
}
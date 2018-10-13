package marshi.android.tuve.ui.recommendVideoList

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import marshi.android.tuve.domain.entity.ChannelId
import marshi.android.tuve.domain.entity.RecommendVideoSnippetEntity
import marshi.android.tuve.repository.api.youtube.YoutubeRepository
import javax.inject.Inject

internal class RecommendVideoListViewModel @Inject constructor(
    private val repository: YoutubeRepository
) {

    val videoSnippetEntityList = MutableLiveData<List<RecommendVideoSnippetEntity>>()

    @SuppressLint("CheckResult")
    fun recommendVideoList() {
        repository.recommend(ChannelId("UCD-miitqNY3nyukJ4Fnf4_A"))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { it -> videoSnippetEntityList.value = it },
                onError = {}
            )
    }
}
package marshi.android.tuve.recommendVideoList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import marshi.android.tuve.R
import marshi.android.tuve.databinding.FragmentFeedListBinding
import marshi.android.tuve.uiUtil.MarginDecoration
import marshi.android.tuve.repository.feed.FeedRepository
import javax.inject.Inject

class RecommendVideoListFragment : Fragment() {
  
  @Inject
  lateinit var feedRepository: FeedRepository
  
  lateinit var binding: FragmentFeedListBinding
  private val disposable = CompositeDisposable()
  private val loadCompleteSubject = PublishSubject.create<Unit>()
  
  companion object {
    @JvmStatic
    fun newInstance() = RecommendVideoListFragment()
  }
  
  override fun onAttach(context: Context?) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)
  }
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(
      inflater, R.layout.fragment_recommend_video_list, container, false
    )
    val adapter = RecommendVideoListAdapter()
    val layoutManager = LinearLayoutManager(context)
    binding.recyclerView.addItemDecoration(MarginDecoration.newInstance(this.context!!, 5, 5))
    binding.recyclerView.layoutManager = layoutManager
    binding.recyclerView.adapter = adapter
    load(adapter)
    return binding.root
  }
  
  private fun load(adapter: RecommendVideoListAdapter) {
    feedRepository.feed()
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeBy (
        onSuccess = { it ->
          it.forEach { entity ->
            adapter.add(entity)
          }
          loadCompleteSubject.onNext(Unit)
        },
        onError = {println("aiueo");println(it)}
      ).addTo(disposable)
  }
  
  override fun onDestroy() {
    super.onDestroy()
    disposable.clear()
  }
}

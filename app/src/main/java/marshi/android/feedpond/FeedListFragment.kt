package marshi.android.feedpond

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.support.v7.widget.scrollEvents
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import marshi.android.feedpond.databinding.FragmentFeedListBinding
import marshi.android.feedpond.feedlist.FeedListAdapter
import marshi.android.feedpond.feedlist.MarginDecoration
import marshi.android.feedpond.repository.feed.FeedRepository
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [FeedListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FeedListFragment : DaggerFragment() {
  
  @Inject
  lateinit var feedRepository: FeedRepository
  
  lateinit var binding: FragmentFeedListBinding
  private val disposable = CompositeDisposable()
  private val loadCompleteSubject = PublishSubject.create<Unit>()
  
  companion object {
    @JvmStatic
    fun newInstance() = FeedListFragment()
  }
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(
      inflater, R.layout.fragment_feed_list, container, false
    )
    val adapter = FeedListAdapter()
    val layoutManager = LinearLayoutManager(context)
    binding.recyclerView.addItemDecoration(MarginDecoration.newInstance(this.context!!, 5, 5))
    binding.recyclerView.layoutManager = layoutManager
    binding.recyclerView.adapter = adapter
    load(adapter)
    return binding.root
  }
  
  private fun load(adapter: FeedListAdapter) {
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

package marshi.android.feedpond

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.support.v7.widget.scrollEvents
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import marshi.android.feedpond.databinding.FragmentFeedListBinding
import marshi.android.feedpond.feedlist.FeedListAdapter
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
    binding.recyclerView.layoutManager = layoutManager
    binding.recyclerView
      .scrollEvents()
      .skipUntil(loadCompleteSubject)
      .filter { layoutManager.itemCount - 1 <= layoutManager.findLastVisibleItemPosition() }
      .take(1)
      .repeat()
      .subscribe {
        load(adapter)
      }.addTo(disposable)
    binding.recyclerView.adapter = adapter
    load(adapter)
    println("oncreate ${Thread.currentThread().name}")
    return binding.root
  }
  
  private fun load(adapter: FeedListAdapter) {
    println("load ${Thread.currentThread().threadGroup.name}")
    feedRepository.feed()
      .observeOn(Schedulers.computation())
      .map { println("map ${Thread.currentThread().name}") ;it }
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeBy (
        onSuccess = { it ->
          it.forEach { entity ->
            adapter.add(entity)
            println("onsuccess ${Thread.currentThread().name}")
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

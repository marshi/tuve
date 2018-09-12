package marshi.android.feedpond

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import marshi.android.feedpond.databinding.FragmentFeedListBinding
import marshi.android.feedpond.domain.FeedItemEntity
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
        adapter.add(FeedItemEntity("aa", "aiueo", ""))
        adapter.add(FeedItemEntity("aa", "aiueo", ""))
        binding.recyclerView.adapter = adapter
        feedRepository.feed()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (
                        onSuccess = ::println,
                        onError = {println("aiueo");println(it)}
                )
        return binding.root
    }
}

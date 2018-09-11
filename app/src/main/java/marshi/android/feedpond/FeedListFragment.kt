package marshi.android.feedpond

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
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
class FeedListFragment : Fragment(), HasSupportFragmentInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var feedRepository: FeedRepository

    lateinit var binding: FragmentFeedListBinding

    companion object {
        @JvmStatic
        fun newInstance() = FeedListFragment()
    }

    @Override
    override fun onAttach(context: Context) {
        AndroidInjection.inject(this)
        super.onAttach(context)
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
        return binding.root
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return injector
    }
}

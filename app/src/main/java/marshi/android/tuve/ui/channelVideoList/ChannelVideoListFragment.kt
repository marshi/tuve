package marshi.android.tuve.ui.channelVideoList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.AndroidSupportInjection
import marshi.android.tuve.databinding.FragmentFeedMediaListBinding
import marshi.android.tuve.uiUtil.MarginDecoration
import javax.inject.Inject

class ChannelVideoListFragment : Fragment() {

    lateinit var binding: FragmentFeedMediaListBinding
    @Inject internal lateinit var vm: ChannelVideoListViewModel

    @Inject
    lateinit var adapter: ChannelVideoAdapter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentFeedMediaListBinding.inflate(inflater, container, false)
        val adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.addItemDecoration(MarginDecoration.newInstance(context!!, 5, 5))
        binding.recyclerView.adapter = adapter
        vm.items.observe(this, Observer { list ->
            if (list.isEmpty()) {
                adapter.clear()
            } else {
                list.forEach { adapter.add(it) }
            }
        })
        initSearchView()
        return binding.root
    }

    private fun initSearchView() {
        val searchView = binding.searchView
        searchView.setOnClickListener {
            // this is dirty hack. Actually, want to call SearchView#onSearchClicked().
            // In setIconified method, onSearchClicked is called.
            // therefore, call setIconified method instead of onSearchClicked.
            searchView.isIconified = false
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query ?: return false
                vm.update(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }
}

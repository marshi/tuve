package marshi.android.tuve.feed_media_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import marshi.android.tuve.R
import marshi.android.tuve.databinding.ActivityFeedMediaListBinding
import marshi.android.tuve.feedlist.MarginDecoration
import javax.inject.Inject

class FeedMediaListActivity : AppCompatActivity() {
  
  lateinit var binding: ActivityFeedMediaListBinding
  @Inject
  lateinit var vm: FeedMediaListViewModel
  
  @Inject
  lateinit var adapter: FeedMediaAdapter
  
  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_feed_media_list)
    val adapter = adapter
    binding.recyclerView.layoutManager = LinearLayoutManager(this)
    binding.recyclerView.addItemDecoration(MarginDecoration.newInstance(this, 5, 5))
    binding.recyclerView.adapter = adapter
    vm.items.observe(this, Observer { list ->
      if (list.isEmpty()) {
        adapter.clear()
      } else {
        list.forEach { adapter.add(it) }
      }
    })
    initSearchView()
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

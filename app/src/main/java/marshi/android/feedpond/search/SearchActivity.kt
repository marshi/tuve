package marshi.android.feedpond.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import marshi.android.feedpond.R
import marshi.android.feedpond.databinding.ActivitySearchBinding
import marshi.android.feedpond.repository.feedly.FeedlyRepository
import javax.inject.Inject


class SearchActivity : AppCompatActivity() {
  
  private lateinit var binding: ActivitySearchBinding
  
  @Inject
  lateinit var repository: FeedlyRepository
  
  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
    val toolbar = binding.toolbar
    toolbar.inflateMenu(R.menu.search)
    val searchView = toolbar.menu.findItem(R.id.menu_search).actionView as SearchView
    searchView.maxWidth = Int.MAX_VALUE
    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String): Boolean {
        repository.search(query)
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe ({ it ->
            println(it)
          }, {
            println(it)
          })
        return false
      }
      
      override fun onQueryTextChange(p0: String?): Boolean {
        return false
      }
    })
    
    binding.button.setOnClickListener {
    
    }
  }
}

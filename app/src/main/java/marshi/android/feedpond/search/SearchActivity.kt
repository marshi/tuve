package marshi.android.feedpond.search

import android.databinding.DataBindingUtil
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import marshi.android.feedpond.R
import marshi.android.feedpond.databinding.ActivitySearchBinding
import marshi.android.feedpond.repository.feedly.FeedlyRepository
import javax.inject.Inject


class SearchActivity : DaggerAppCompatActivity() {
  
  private lateinit var binding: ActivitySearchBinding
  
  @Inject
  lateinit var repository: FeedlyRepository
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
    binding.button.setOnClickListener {
      repository.search().observeOn(AndroidSchedulers.mainThread()).subscribe { it ->
        println("aaaaa: $it")
      }
    }
  }
  
}

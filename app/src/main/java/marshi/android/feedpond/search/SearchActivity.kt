package marshi.android.feedpond.search

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import marshi.android.feedpond.R
import marshi.android.feedpond.databinding.ActivitySearchBinding
import marshi.android.feedpond.repository.feedly.FeedlyRepository


class SearchActivity : AppCompatActivity() {
  
  private lateinit var binding: ActivitySearchBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
    binding.button.setOnClickListener {
      val repository = FeedlyRepository()
      repository.search().observeOn(AndroidSchedulers.mainThread()).subscribe { it -> println(it) }
    }
  }
  
}

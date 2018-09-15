package marshi.android.feedpond

import android.databinding.DataBindingUtil
import android.os.Bundle
import androidx.navigation.findNavController
import dagger.android.support.DaggerAppCompatActivity
import marshi.android.feedpond.databinding.ActivityMainBinding

class MainActivity : DaggerAppCompatActivity() {
  
  lateinit var binding: ActivityMainBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
  }
  
  override fun onSupportNavigateUp(): Boolean =
    findNavController(R.id.nav_host).navigateUp()
  
}

package marshi.android.feedpond

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import marshi.android.feedpond.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  
  lateinit var binding: ActivityMainBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
  }
  
  override fun onSupportNavigateUp(): Boolean =
    findNavController(R.id.nav_host).navigateUp()
  
}

package marshi.android.tuve.activity

import android.os.Bundle
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import marshi.android.tuve.R
import marshi.android.tuve.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
  
  @Inject
  lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>
  lateinit var binding: ActivityMainBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
  }
  
  override fun onSupportNavigateUp(): Boolean =
    findNavController(R.id.nav_host).navigateUp()
  
  override fun supportFragmentInjector() = supportFragmentInjector
}

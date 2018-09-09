package marshi.android.feedpond


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [FeedListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FeedListFragment : Fragment(), HasSupportFragmentInjector {

    @Inject lateinit var injector: DispatchingAndroidInjector<Fragment>

    companion object {
        @JvmStatic
        fun newInstance() = FeedListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed_list, container, false)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return injector
    }
}

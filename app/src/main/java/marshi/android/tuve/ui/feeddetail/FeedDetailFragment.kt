package marshi.android.tuve.ui.feeddetail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import marshi.android.tuve.databinding.FragmentFeedDetailBinding
import java.net.URI

class FeedDetailFragment : Fragment() {
  
  companion object {
    @JvmStatic
    fun newInstance() = FeedDetailFragment()
  }
  
  private lateinit var binding: FragmentFeedDetailBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }
  
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    
    binding = FragmentFeedDetailBinding.inflate(inflater, container, false)
    binding.apply {
      webview.settings.javaScriptEnabled = true
      webview.webViewClient = WebViewClient()
      val uri = arguments!!.get("uri") as URI
      webview.loadUrl(uri.toString())
    }
    return binding.root
  }
  
}

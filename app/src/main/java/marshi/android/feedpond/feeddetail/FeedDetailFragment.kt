package marshi.android.feedpond.feeddetail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import marshi.android.feedpond.databinding.FragmentFeedDetailBinding

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
      article.text = arguments!!.getString("article", "")
      title.text = arguments!!.getString("title", "")
    }
    return binding.root
  }
  
}

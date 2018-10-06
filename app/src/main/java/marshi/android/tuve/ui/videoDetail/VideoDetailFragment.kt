package marshi.android.tuve.ui.videoDetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener
import dagger.android.support.AndroidSupportInjection
import marshi.android.tuve.databinding.FragmentVideoDetailBinding

class VideoDetailFragment : Fragment() {

    private lateinit var binding: FragmentVideoDetailBinding

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val videoId = arguments!!.getString("videoId")
        binding = FragmentVideoDetailBinding.inflate(inflater, container, false)
        val youtubePlayer = binding.youtubePlayer
        youtubePlayer.initialize({
            it.addListener(object: AbstractYouTubePlayerListener() {
                override fun onReady() {
                    it.loadVideo(videoId!!, 0f)
                }
            })
        }, true)
        return binding.root
    }
}

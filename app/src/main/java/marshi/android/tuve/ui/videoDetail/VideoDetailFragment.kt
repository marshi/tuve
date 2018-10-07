package marshi.android.tuve.ui.videoDetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener
import dagger.android.support.AndroidSupportInjection
import marshi.android.tuve.databinding.FragmentVideoDetailBinding
import marshi.android.tuve.ui.channelSnippetList.ChannelVideoSnippetListAdapter
import marshi.android.tuve.uiUtil.MarginDecoration
import javax.inject.Inject

class VideoDetailFragment : Fragment() {

    companion object {
        const val VIDEO_ID = "videoId"
        const val CHANNEL_ID = "channelId"
    }

    private lateinit var binding: FragmentVideoDetailBinding
    @Inject lateinit var vm: VideoDetailBottomListViewModel
    @Inject lateinit var adapter: ChannelVideoSnippetListAdapter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val videoId = arguments!!.getString(VIDEO_ID)
        val channelId = arguments!!.getString(CHANNEL_ID)
        binding = FragmentVideoDetailBinding.inflate(inflater, container, false)
        val youtubePlayer = binding.youtubePlayer
        youtubePlayer.initialize({
            it.addListener(object : AbstractYouTubePlayerListener() {
                override fun onReady() {
                    it.loadVideo(videoId!!, 0f)
                }
            })
        }, false)

        binding.recyclerView.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(context)
            it.addItemDecoration(MarginDecoration.newInstance(context!!, 5, 5))
        }
        vm.videoSnippetEntities.observe(this, Observer{ entities ->
            adapter.addAll(entities)
        })
        vm.channel(channelId)
        return binding.root
    }
}

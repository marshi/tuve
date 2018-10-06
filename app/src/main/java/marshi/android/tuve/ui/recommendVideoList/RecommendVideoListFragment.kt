package marshi.android.tuve.ui.recommendVideoList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.AndroidSupportInjection
import marshi.android.tuve.R
import marshi.android.tuve.databinding.FragmentRecommendVideoListBinding
import marshi.android.tuve.uiUtil.MarginDecoration
import javax.inject.Inject

class RecommendVideoListFragment : Fragment() {

    lateinit var binding: FragmentRecommendVideoListBinding
    @Inject internal lateinit var vm: RecommendVideoListViewModel
    @Inject internal lateinit var adapter: RecommendVideoListAdapter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_recommend_video_list, container, false
        )
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.addItemDecoration(MarginDecoration.newInstance(this.context!!, 5, 5))
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        vm.recommendVideoList()
        vm.videoSnippetEntityList.observe(this, Observer {
            adapter.addAll(it)
        })
        return binding.root
    }
}


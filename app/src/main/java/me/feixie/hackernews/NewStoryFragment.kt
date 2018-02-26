package me.feixie.hackernews


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 *
 */
class NewStoryFragment : Fragment() {

    private var mStory: String? = null
    private lateinit var mViewModel: HackerViewModel

    companion object {
        fun newInstance(): NewStoryFragment {
            return NewStoryFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_new_story, container, false)
        initData()
        initView()
        return view
    }

    private fun initView() {
        mStory?.apply {
            mViewModel.getLiveStories(mStory as String).observe(this@NewStoryFragment, Observer<List<Int>> { items ->
                Timber.d(items.toString())
            })
        }
    }

    private fun initData() {
        mViewModel = ViewModelProviders.of(this).get(HackerViewModel::class.java)
        mStory = arguments?.get(FRAGMENT_TAG) as String
    }


}

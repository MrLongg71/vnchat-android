package vn.mrlongg71.vnchat.src.module.diary.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_diary.*
import kotlinx.android.synthetic.main.fragment_diary.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.mrlongg71.vnchat.R
import vn.mrlongg71.vnchat.src.adapter.PostsAdapter
import vn.mrlongg71.vnchat.src.module.posts.viewmodel.PostsViewModel

/**
 * A simple [Fragment] subclass.
 */
class DiaryFragment : Fragment() {
    private val postsViewModel: PostsViewModel by viewModel()
    private var postAdapter: PostsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_diary, container, false)


        postsViewModel.handlerGetPosts().observe(viewLifecycleOwner, Observer {
            Log.d("LONgKUTE", "${it[0].images[0].url}: ");
            postAdapter = PostsAdapter(it!!)

            recyclerPosts.layoutManager = LinearLayoutManager(activity)

            view.recyclerPosts.adapter = postAdapter


            postAdapter!!.notifyDataSetChanged()
        })
        return view

    }

}

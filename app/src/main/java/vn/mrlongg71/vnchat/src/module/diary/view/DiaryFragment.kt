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
import kotlinx.android.synthetic.main.layout_footer_posts.view.*
import kotlinx.android.synthetic.main.layout_story.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.mrlongg71.vnchat.R
import vn.mrlongg71.vnchat.src.adapter.PostsAdapter
import vn.mrlongg71.vnchat.src.adapter.StoryAdapter
import vn.mrlongg71.vnchat.src.data.model.Images
import vn.mrlongg71.vnchat.src.data.model.Posts
import vn.mrlongg71.vnchat.src.module.diary.interfacePosts.IOnClickEventPosts
import vn.mrlongg71.vnchat.src.module.posts.viewmodel.PostsViewModel
import vn.mrlongg71.vnchat.src.network.EndPoint

/**
 * A simple [Fragment] subclass.
 */
class DiaryFragment : Fragment(), IOnClickEventPosts {
    private val postsViewModel: PostsViewModel by viewModel()
    private var postAdapter: PostsAdapter? = null
    private var storyAdapter: StoryAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_diary, container, false)


        postsViewModel.handlerGetPosts().observe(viewLifecycleOwner, Observer {
            postAdapter = PostsAdapter(it!!, this)

            recyclerPosts.layoutManager = LinearLayoutManager(activity)

            view.recyclerPosts.adapter = postAdapter


            postAdapter!!.notifyDataSetChanged()
        })

        val listStory: ArrayList<Images> = ArrayList()
        listStory.add(Images("1", "1", EndPoint.BASE_URL_U.plus("img.jpg"), 100.0, 100.0))
        listStory.add(Images("1", "1", EndPoint.BASE_URL_U.plus("img.jpg"), 100.0, 100.0))
        listStory.add(Images("1", "1", EndPoint.BASE_URL_U.plus("img.jpg"), 100.0, 100.0))
        listStory.add(Images("1", "1", EndPoint.BASE_URL_U.plus("img.jpg"), 100.0, 100.0))
        listStory.add(Images("1", "1", EndPoint.BASE_URL_U.plus("img.jpg"), 100.0, 100.0))
        listStory.add(Images("1", "1", EndPoint.BASE_URL_U.plus("img.jpg"), 100.0, 100.0))

        storyAdapter = StoryAdapter(listStory)
        view.recyclerStory.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        view.recyclerStory.adapter = storyAdapter

        storyAdapter!!.notifyDataSetChanged()


        return view

    }


    override fun actionLike(view: View, posts: Posts) {
        if (posts.isLike) {
            view.btnLikePost.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_unheart,
                0,
                0,
                0
            )
            posts.isLike = false
            posts.likeCount = (posts.likeCount.toInt() - 1).toString()
            postAdapter!!.notifyDataSetChanged()
        } else {
            view.btnLikePost.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_heart,
                0,
                0,
                0
            )
            posts.likeCount = (posts.likeCount.toInt() + 1).toString()
            posts.isLike = true
            postAdapter!!.notifyDataSetChanged()


        }
    }

    override fun actionUnLike(view: View, idPost: String, isLike: Boolean) {
        TODO("Not yet implemented")
    }


}

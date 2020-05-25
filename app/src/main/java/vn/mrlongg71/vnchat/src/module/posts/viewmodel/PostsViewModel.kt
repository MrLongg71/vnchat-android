package vn.mrlongg71.vnchat.src.module.posts.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vn.mrlongg71.vnchat.src.data.model.BaseResponse
import vn.mrlongg71.vnchat.src.data.model.Posts
import vn.mrlongg71.vnchat.src.data.repository.posts.PostsRepository

class PostsViewModel(private val postsRepository: PostsRepository) : ViewModel() {

    class GetPosts(private val postsRepository: PostsRepository) : ViewModel(),
        Callback<BaseResponse<List<Posts>>> {

        private val _isLoading = MutableLiveData<Boolean>()
        val isLoading: LiveData<Boolean>
            get() = _isLoading

        private val posts = MutableLiveData<List<Posts>>()

        fun handlerGetPosts(): LiveData<List<Posts>> {
            _isLoading.value = true
            postsRepository.getPosts().enqueue(this)
            return posts
        }

        override fun onFailure(call: Call<BaseResponse<List<Posts>>>, t: Throwable) {
            Log.d("LONgKUTE", "fail: ${t.message} ");

            // handle error
            _isLoading.value = false
        }

        override fun onResponse(
            call: Call<BaseResponse<List<Posts>>>,
            response: Response<BaseResponse<List<Posts>>>
        ) {
            if (response.isSuccessful) {
                posts.value = response.body()!!.data
            } else {
                // handle error
                   posts.value = response.body()!!.data
            }
            _isLoading.value = false
        }
    }

    class ActionLike(private val postsRepository: PostsRepository) : ViewModel(),
        Callback<BaseResponse<String>> {
        private val like = MutableLiveData<Int>()


        fun handlerLikePosts(idPost: String, idUser: String): LiveData<Int> {
            postsRepository.actionLike(idPost, idUser).enqueue(this)
            return like
        }

        fun handlerUnLikePosts(idPost: String, idUser: String): LiveData<Int> {
            postsRepository.actionUnLike(idPost, idUser).enqueue(this)
            return like
        }

        override fun onFailure(call: Call<BaseResponse<String>>, t: Throwable) {
            Log.d("LONgKUTE", "fail: ${t.message} ");
        }

        override fun onResponse(
            call: Call<BaseResponse<String>>,
            response: Response<BaseResponse<String>>
        ) {
            if (response.isSuccessful) {
                like.value = response.body()!!.statusCode
            } else {
                // handle error
                like.value = response.body()!!.statusCode
                Log.d("LONgKUTE", ":err ");
            }
        }
    }


}


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

class PostsViewModel(private val bookRepository: PostsRepository) : ViewModel(),
    Callback<BaseResponse<List<Posts>>> {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val posts = MutableLiveData<List<Posts>>()
    private val like = MutableLiveData<String>()

    fun handlerGetPosts(): LiveData<List<Posts>> {
        _isLoading.value = true
        bookRepository.getPosts().enqueue(this)
        return posts
    }

    //    fun handlerLikePosts(idPost:String,idUser: String): LiveData<BaseResponse<String>> {
//        bookRepository.actionLike(idPost,idUser)
//    }
//    fun handlerUnLikePosts(idPost:String,idUser: String): LiveData<BaseResponse<String>> {
//        bookRepository.actionUnLike(idPost,idUser)
//        return like
//    }
    override fun onFailure(call: Call<BaseResponse<List<Posts>>>, t: Throwable) {
        Log.d("LONgKUTE", "fail: ${t.message} ");

        // handle error
        _isLoading.value = false

        // posts.value = BaseResponse(500, t.message.toString(), null)
    }

    override fun onResponse(
        call: Call<BaseResponse<List<Posts>>>,
        response: Response<BaseResponse<List<Posts>>>
    ) {
        if (response.isSuccessful) {
            posts.value = response.body()!!.data
        } else {
            // handle error
//            posts.value = response.body()!!.data
            Log.d("LONgKUTE", ":err ");
        }
        _isLoading.value = false
    }
}


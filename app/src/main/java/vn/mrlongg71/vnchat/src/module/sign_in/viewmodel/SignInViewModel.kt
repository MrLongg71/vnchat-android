package vn.mrlongg71.vnchat.src.module.sign_in.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import vn.mrlongg71.vnchat.src.data.model.BaseResponse
import vn.mrlongg71.vnchat.src.data.model.User
import vn.mrlongg71.vnchat.src.data.repository.user.SignInRepository

class SignInViewModel(private val bookRepository: SignInRepository) : ViewModel(),
    Callback<BaseResponse<User>> {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _user = MutableLiveData<BaseResponse<User>>()

    fun handlerSignIn(email: String, password: String): LiveData<BaseResponse<User>> {
        _isLoading.value = true
        bookRepository.getAllBooks(email, password).enqueue(this)
        return _user
    }

    override fun onFailure(call: Call<BaseResponse<User>>, t: Throwable) {
        // handle error
        _isLoading.value = false
        _user.value = BaseResponse(500, t.message.toString(), null)
    }

    override fun onResponse(
        call: Call<BaseResponse<User>>,
        response: Response<BaseResponse<User>>
    ) {
        if (response.isSuccessful) {
            _user.value = response.body()
        } else {
            // handle error
            _user.value = response.body()
        }
        _isLoading.value = false
    }
}





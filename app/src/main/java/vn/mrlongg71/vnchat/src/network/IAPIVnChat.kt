package vn.mrlongg71.vnchat.src.network

import retrofit2.Call
import retrofit2.http.*
import vn.mrlongg71.vnchat.src.data.model.BaseResponse
import vn.mrlongg71.vnchat.src.data.model.User

interface IAPIVnChat {
    @FormUrlEncoded
    @POST("users/sign-in.php")
    fun handlerLogin(
        @Field("email") email: String?,
        @Field("password") password: String?
    ): Call<BaseResponse<User>>

}
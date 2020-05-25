package vn.mrlongg71.vnchat.src.network

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import vn.mrlongg71.vnchat.src.data.model.BaseResponse
import vn.mrlongg71.vnchat.src.data.model.Posts
import vn.mrlongg71.vnchat.src.data.model.User

interface IAPIVnChat {
    //user
    @FormUrlEncoded
    @POST("users/sign-in.php")
    fun handlerLogin(
        @Field("email") email: String?,
        @Field("password") password: String?
    ): Call<BaseResponse<User>>

    @FormUrlEncoded
    @POST("users/sign-up.php")
    fun handlerSignUp(
        @Field("phone") phone: String?,
        @Field("fullname") name: String?,
        @Field("gender") gender: String?,
        @Field("password") password: String?
    ): Call<BaseResponse<User>>



    //posts
    @GET("posts/paging-post.php")
    fun handlerGetPosts(): Call<BaseResponse<List<Posts>>>

    @FormUrlEncoded
    @POST("posts/action-like.php")
    fun handlerLike(
        @Field("idPost") idPost: String,
        @Field("idUser") idUser: String
    ): Call<BaseResponse<String>>

    @FormUrlEncoded
    @POST("posts/action-un-like.php")
    fun handlerUnLike(
        @Field("idPost") idPost: String,
        @Field("idUser") idUser: String
    ): Call<BaseResponse<String>>
}
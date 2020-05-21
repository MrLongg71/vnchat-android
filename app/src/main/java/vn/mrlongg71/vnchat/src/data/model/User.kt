package vn.mrlongg71.vnchat.src.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class User(

    var email: String? = null,

    var fullname: String? = null,

    @SerializedName("birthday")
    @Expose
    var birthday: String? = null,

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null,

    @SerializedName("phone")
    @Expose
    var phone: String? = null,

    @SerializedName("status")
    @Expose
    var status: String? = null,

    @SerializedName("background_image")
    @Expose
    var backgroundImage: String? = null,

    @SerializedName("address")
    @Expose
    var address: String? = null,

    @SerializedName("gender")
    @Expose
    var gender: String? = null,

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null,

    @SerializedName("update_at")
    @Expose
    var updateAt: String? = null

)
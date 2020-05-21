package vn.mrlongg71.vnchat.src.data.model

data class BaseResponse<T>(

     var statusCode: Int = 0,
     var message: String = "",
     var data: T? = null

)
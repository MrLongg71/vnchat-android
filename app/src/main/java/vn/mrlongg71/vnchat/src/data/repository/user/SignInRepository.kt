package vn.mrlongg71.vnchat.src.data.repository.user

import org.koin.dsl.module
import vn.mrlongg71.vnchat.src.data.model.BaseResponse
import vn.mrlongg71.vnchat.src.data.model.User
import vn.mrlongg71.vnchat.src.network.IAPIVnChat
import vn.mrlongg71.vnchat.src.network.Resource
import vn.mrlongg71.vnchat.src.network.ResponseHandler


open class SignInRepository(private val iApiService: IAPIVnChat) {
    fun getAllBooks(email:String, password:String) = iApiService.handlerLogin(email,password)

}
package vn.mrlongg71.vnchat.src.data.repository.user

import vn.mrlongg71.vnchat.src.network.IAPIVnChat


open class UserRepository(private val iApiService: IAPIVnChat) {
    fun signIn(email: String, password: String) = iApiService.handlerLogin(email, password)
    fun signUp(phone: String, name: String, gender: String, password: String) =
        iApiService.handlerSignUp(phone, name, gender, password)
}
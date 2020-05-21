package vn.mrlongg71.vnchat.src.network

class EndPoint {
    var REGISTER = "/users/register"
    var PROFILE = "/users/profile"

    companion object {
        var BASE_URL = "http://localhost/vnchat-backend-php/server/api/"
        var BASE_URL_PUBLIC = "https://vn-food.herokuapp.com/public/photo/"

        //**** User ****//
        var LOGIN = "/users/login"
    }
}
package vn.mrlongg71.vnchat.src.data.model

//
//{
//    "idPost": "1",
//    "description": "hom nay abc",
//    "limits": "0",
//    "likeCount": "2",
//    "commentCount": "4",
//    "created_at": "2020-05-11 00:00:00",
//    "idUser": "29",
//    "fullname": "Nguyễn Hoàng Long",
//    "avatar": "20"
//},
data class Posts(
    val idPost: String,
    val description: String,
    val limits: String,
    var likeCount: String,
    var commentCount: String,
    var isLike : Boolean,
    val images: List<Images>,
    val idUser: String,
    val fullname: String,
    val avatar: String
)
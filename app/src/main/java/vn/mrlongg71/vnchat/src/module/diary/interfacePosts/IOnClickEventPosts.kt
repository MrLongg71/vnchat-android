package vn.mrlongg71.vnchat.src.module.diary.interfacePosts

import android.view.View
import vn.mrlongg71.vnchat.src.data.model.Posts

interface IOnClickEventPosts {
        fun actionLike(view: View,posts: Posts)

//    interface  IOnClickComment{
//        fun actionLike(idPost: String);
//        fun actionUnLike(idPost: String);
//    }
}
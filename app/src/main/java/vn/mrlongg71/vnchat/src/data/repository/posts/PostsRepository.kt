package vn.mrlongg71.vnchat.src.data.repository.posts

import vn.mrlongg71.vnchat.src.network.IAPIVnChat


open class PostsRepository(private val iApiService: IAPIVnChat) {
    fun getPosts() = iApiService.handlerGetPosts()


}
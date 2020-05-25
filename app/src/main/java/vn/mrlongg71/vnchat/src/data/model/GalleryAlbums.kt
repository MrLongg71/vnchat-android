package vn.mrlongg71.vnchat.src.data.model

import kotlin.collections.ArrayList

data class GalleryAlbums(var id: Int = 0, var name: String = "", var coverUri: String = "", var albumPhotos: ArrayList<GalleryData> = ArrayList())
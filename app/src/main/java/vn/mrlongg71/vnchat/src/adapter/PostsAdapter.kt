package vn.mrlongg71.vnchat.src.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.custom_item_post_desc.view.*
import kotlinx.android.synthetic.main.custom_item_posts_image_four.view.*
import kotlinx.android.synthetic.main.custom_item_posts_image_one.view.*
import kotlinx.android.synthetic.main.custom_item_posts_image_three.view.*
import kotlinx.android.synthetic.main.custom_item_posts_image_two.view.*
import vn.mrlongg71.vnchat.R
import vn.mrlongg71.vnchat.src.data.model.Posts
import vn.mrlongg71.vnchat.src.network.EndPoint


class PostsAdapter(private var postListItem: List<Posts>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val DESC = 0
    private val IMAGE_ONE = 1
    private val IMAGES_TWO = 2
    private val IMAGES_THREE = 3
    private val IMAGES_FOUR = 4


    class DescViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(posts: Posts) {
            itemView.txtDesc.text = posts.description
        }
    }

    class ImageOneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(posts: Posts) {
            Log.d("LONgKUTE", "size one: ${posts.images.size} ");
            android.util.Log.d("LONgKUTE", "load images:${EndPoint.BASE_URL_U.plus(posts.images[0].url)} ")
            Glide.with(itemView.context).load(EndPoint.BASE_URL_U.plus(posts.images[0].url)).into(itemView.imgImageOne)
            itemView.txtDescImageOne.text = posts.description
        }
    }

    class ImagesTwoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(posts: Posts) {
            Log.d("LONgKUTE", "size two: ${posts.images.size} ");
            Glide.with(itemView.context).load(EndPoint.BASE_URL_U.plus(posts.images[0].url)).into(itemView.img1ImageTwo)
            Glide.with(itemView.context).load(EndPoint.BASE_URL_U.plus(posts.images[1].url)).into(itemView.img2ImageTwo)
            itemView.txtDescImageTwo.text = posts.description
        }
    }

    class ImagesThreeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(posts: Posts) {
            Log.d("LONgKUTE", "size three: ${posts.images.size} ");

            android.util.Log.d("LONgKUTE", "load images three :${EndPoint.BASE_URL_U.plus(posts.images[1].url)} ")

            Glide.with(itemView.context).load(EndPoint.BASE_URL_U.plus(posts.images[0].url)).into(itemView.img1ImageThree)
            Glide.with(itemView.context).load(EndPoint.BASE_URL_U.plus(posts.images[1].url)).into(itemView.img2ImageThree)
            Glide.with(itemView.context).load(EndPoint.BASE_URL_U.plus(posts.images[2].url)).into(itemView.img3ImageThree)
            itemView.txtDescImageThree.text = posts.description
        }
    }

    class ImagesFourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(posts: Posts) {
            Log.d("LONgKUTE", "size four: ${posts.images.size} ");

            Glide.with(itemView.context).load(EndPoint.BASE_URL_U.plus(posts.images[0].url)).into(itemView.img1ImageFour)
            Glide.with(itemView.context).load(EndPoint.BASE_URL_U.plus(posts.images[1].url)).into(itemView.img2ImageFour)
            Glide.with(itemView.context).load(EndPoint.BASE_URL_U.plus(posts.images[2].url)).into(itemView.img3ImageFour)
            Glide.with(itemView.context).load(EndPoint.BASE_URL_U.plus(posts.images[3].url)).into(itemView.img4ImageFour)
            itemView.txtDescImageFour.text = posts.description
        }
    }

    override fun getItemViewType(position: Int): Int {
      return when(postListItem[position].images.size){
            0 -> DESC
            1 -> IMAGE_ONE
            2 -> IMAGES_TWO
            3 -> IMAGES_THREE
            4 -> IMAGES_FOUR
          else -> 10
      }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val li = LayoutInflater.from(parent.context)
        val viewNull: View =
            li.inflate(R.layout.custom_item_post_desc, parent, false)
        when (viewType) {
            DESC -> {
                val desc: View =
                    li.inflate(R.layout.custom_item_post_desc, parent, false)
                return DescViewHolder(desc)
            }
            IMAGE_ONE -> {
                val imageOne: View =
                    li.inflate(R.layout.custom_item_posts_image_one, parent, false)
                return ImageOneViewHolder(imageOne)
            }
            IMAGES_TWO -> {
                val imagesTwo: View =
                    li.inflate(R.layout.custom_item_posts_image_two, parent, false)
                return ImagesTwoViewHolder(imagesTwo)
            }
            IMAGES_THREE -> {
                val imagesThree: View =
                    li.inflate(R.layout.custom_item_posts_image_three, parent, false)
                return ImagesThreeViewHolder(imagesThree)
            }
            IMAGES_FOUR -> {
                val imagesFour: View =
                    li.inflate(R.layout.custom_item_posts_image_four, parent, false)
                return ImagesFourViewHolder(imagesFour)
            }

        }
        return DescViewHolder(viewNull)

    }

    override fun getItemCount(): Int {
        return postListItem.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            DESC -> {
                (holder as DescViewHolder).bind(postListItem[position])
            }
            IMAGE_ONE -> {
                (holder as ImageOneViewHolder).bind(postListItem[position])

            }
            IMAGES_TWO -> {
                (holder as ImagesTwoViewHolder).bind(postListItem[position])

            }
            IMAGES_THREE -> {
                (holder as ImagesThreeViewHolder).bind(postListItem[position])

            }
            IMAGES_FOUR -> {
                (holder as ImagesFourViewHolder).bind(postListItem[position])

            }

        }
    }

}
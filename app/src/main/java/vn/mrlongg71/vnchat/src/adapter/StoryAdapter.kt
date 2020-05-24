package vn.mrlongg71.vnchat.src.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.custom_item_story.view.*
import vn.mrlongg71.vnchat.R
import vn.mrlongg71.vnchat.src.data.model.Images

class StoryAdapter(var storyList: List<Images>) :
    RecyclerView.Adapter<StoryAdapter.ViewHolderStory>() {

    class ViewHolderStory(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.custom_item_story, parent, false)) {


        fun bind(images: Images) {
            Glide.with(itemView.context).load(images.url).apply(RequestOptions.bitmapTransform(BlurTransformation(25,1))).into(itemView.roundImageStory)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderStory {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolderStory(inflater, parent)
    }

    override fun onBindViewHolder(holder: ViewHolderStory, position: Int) {
        val images: Images = storyList[position]
        holder.bind(images)
    }

    override fun getItemCount(): Int = storyList.size

}


package vn.mrlongg71.vnchat.src.adapter

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.custom_item_choose_media.view.*
import vn.mrlongg71.vnchat.R
import java.io.File

class StaggeredAdapter(
    val context: Context,
    private var imagesChoose: List<String>?
) : RecyclerView.Adapter<StaggeredAdapter.ViewHolderChooseMedia>() {
    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onBindViewHolder(holder: ViewHolderChooseMedia, position: Int) {
        Log.d("LONgKUTE", "load images: ");
        Glide.with(context).load(
            File(Uri.parse(imagesChoose?.get(position)!!).path)
        ).into(holder.image)
        holder.clear.setOnClickListener {
            // todo
        }
    }


    override fun getItemCount(): Int {
        return imagesChoose!!.size
    }

    class ViewHolderChooseMedia(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.imgRoundChooseMedia!!
        val clear = view.actionClearImgChooseMedia!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderChooseMedia {
        return ViewHolderChooseMedia(
            layoutInflater.inflate(
                R.layout.custom_item_choose_media,
                parent,
                false
            )
        )

    }
}

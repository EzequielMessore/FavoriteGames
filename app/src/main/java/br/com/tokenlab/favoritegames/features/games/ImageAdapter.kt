package br.com.tokenlab.favoritegames.features.games

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.tokenlab.favoritegames.R
import br.com.tokenlab.favoritegames.data.entities.Platform
import kotlinx.android.synthetic.main.item_image.view.*

/**
 * Created by Ezequiel Messore on 26/08/2017.
 * ezequielmessore.developer@gmail.com
 */
class ImageAdapter(val context: Context) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private var simpleName = ImageAdapter::class.java.simpleName
    private val itemsList = ArrayList<Platform>()

    var items: List<Platform>?
        get() = itemsList
        set(value) {
            itemsList.clear()
            if (value != null && value.isNotEmpty()) {
                itemsList.addAll(value)
            }
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = items!!.size

    private fun getItem(position: Int) = itemsList[position]

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(platform: Platform) {
            itemView.iv_platform.setImageDrawable(ContextCompat.getDrawable(context, platform.getMipmap()))
        }
    }
}
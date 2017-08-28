package br.com.tokenlab.favoritegames.features.games

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.tokenlab.favoritegames.R
import br.com.tokenlab.favoritegames.data.entities.Game
import br.com.tokenlab.favoritegames.utils.AppUtil
import kotlinx.android.synthetic.main.item_game.view.*

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
class GamesListAdapter(val listener: OnGameClickListener) : RecyclerView.Adapter<GamesListAdapter.GamesViewHolder>() {

    private val itemsList = ArrayList<Game>()

    var items: List<Game>?
        get() = itemsList
        set(value) {
            itemsList.clear()
            if (value != null && value.isNotEmpty()) {
                itemsList.addAll(value)
            }
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        return GamesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false))
    }

    override fun onBindViewHolder(holder: GamesViewHolder?, position: Int) {
        holder?.bind(getItem(position))
    }

    override fun getItemCount() = items!!.size

    private fun getItem(position: Int) = itemsList[position]

    inner class GamesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(game: Game) {
            itemView.tv_name.text = game.name
            itemView.tv_date.text = AppUtil.formatDate(game.releaseDate)

            itemView.sm.setImageURI(null as String?)
            itemView.sm.setImageURI(game.image)

            itemView.iv_play.setOnClickListener({ listener.onClickPlay(game.trailer) })

            val adapter = ImageAdapter(listener.getContext())
            adapter.items = game.platforms.sorted()
            itemView.recyclerView.adapter = adapter
        }

    }

    interface OnGameClickListener {
        fun onClickPlay(url: String)
        fun getContext(): Context
    }
}
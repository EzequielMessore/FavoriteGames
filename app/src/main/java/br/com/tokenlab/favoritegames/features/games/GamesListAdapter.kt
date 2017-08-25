package br.com.tokenlab.favoritegames.features.games

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.tokenlab.favoritegames.R
import br.com.tokenlab.favoritegames.data.entities.Game
import kotlinx.android.synthetic.main.item_game.view.*

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
class GamesListAdapter (val listener: OnGameClickListener) : RecyclerView.Adapter<GamesListAdapter.GamesViewHolder>() {

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
            itemView.setOnClickListener { listener.onClick(game) }
            itemView.tv_name.text = game.name
            itemView.sm.setImageURI(null as String?)
            itemView.sm.setImageURI(game.image)

        }

    }

    interface OnGameClickListener {
        fun onClick(games: Game)
    }
}
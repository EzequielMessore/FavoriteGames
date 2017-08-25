package br.com.tokenlab.favoritegames.data.entities

import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel
import paperparcel.PaperParcelable
import java.util.*

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
@PaperParcel data class Game(
        val id: Int,
        val name: String,
        val image: String,
        @SerializedName("release_date")
        val releaseDate: Date,
        val trailer: String,
        val platforms: List<String>
) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelGame.CREATOR
    }
}
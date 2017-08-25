package br.com.tokenlab.favoritegames.data.model

import br.com.tokenlab.favoritegames.data.entities.Game
import io.reactivex.Observable

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
interface GamesModel {
    fun getGames(): Observable<List<Game>>
}
package br.com.tokenlab.favoritegames.data.net.games

import br.com.tokenlab.favoritegames.data.entities.GamesResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
interface GamesService {
    @GET("games")
    fun getGames(): Observable<GamesResponse>
}
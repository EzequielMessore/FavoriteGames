package br.com.tokenlab.favoritegames.data.model.impl

import br.com.tokenlab.favoritegames.data.entities.Game
import br.com.tokenlab.favoritegames.data.model.GamesModel
import br.com.tokenlab.favoritegames.data.net.ServiceGenerator
import br.com.tokenlab.favoritegames.data.net.games.GamesService
import io.reactivex.Observable

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
class GamesModelImpl : GamesModel {
    override fun getGames(): Observable<List<Game>>
            = ServiceGenerator.getService(GamesService::class.java)
            .getGames()
            .map { (games) -> games }
}
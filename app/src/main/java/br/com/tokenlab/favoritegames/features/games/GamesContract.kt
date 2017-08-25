package br.com.tokenlab.favoritegames.features.games

import br.com.tokenlab.favoritegames.data.entities.Game
import br.com.tokenlab.favoritegames.features.base.presenter.BasePresenter
import br.com.tokenlab.favoritegames.features.base.view.LoadingView
import io.reactivex.Observable

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
interface GamesContract {
    interface View : LoadingView {
        fun load(list: List<Game>)
    }

    interface Presenter : BasePresenter<View> {
        fun list(): Observable<List<Game>>
    }
}
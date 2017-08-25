package br.com.tokenlab.favoritegames.features.games

import br.com.tokenlab.favoritegames.data.entities.Game
import br.com.tokenlab.favoritegames.data.model.GamesModel
import br.com.tokenlab.favoritegames.features.base.presenter.BasePresenterImpl
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
class GamesPresenter(private val gamesModel: GamesModel)
    : GamesContract.Presenter, BasePresenterImpl<GamesContract.View>() {

    override fun list(): Observable<List<Game>> {
        return execWithView(gamesModel.getGames(), GamesObservable())
    }

    inner class GamesObservable : DisposableObserver<List<Game>>() {
        override fun onNext(games: List<Game>) {
            view?.load(games)
        }

        override fun onComplete() {

        }

        override fun onError(e: Throwable) {

        }
    }

}
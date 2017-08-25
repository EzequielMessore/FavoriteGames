package br.com.tokenlab.favoritegames.features.base.view

import br.com.tokenlab.favoritegames.features.base.presenter.BasePresenter

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
interface ViewPresenter<Presenter : BasePresenter<*>> {
    var presenter: Presenter
}
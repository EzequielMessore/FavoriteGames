package br.com.tokenlab.favoritegames.features.base.presenter

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
interface BasePresenter<in View> {
    fun attach(view: View)
    fun detach()
}
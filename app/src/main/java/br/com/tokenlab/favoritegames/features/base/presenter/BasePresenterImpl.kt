package br.com.tokenlab.favoritegames.features.base.presenter

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.lang.ref.WeakReference


/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
open class BasePresenterImpl <View> : BasePresenter<View> {

    private var viewReference: WeakReference<View>? = null
    private var disposables: CompositeDisposable? = null

    protected var view: View? = null
        get() = viewReference?.get()
        private set

    //region BasePresenter
    override fun attach(view: View) {
        viewReference = WeakReference<View>(view)
    }

    override fun detach() {
        viewReference?.clear()
        if (disposables != null && !disposables!!.isDisposed) {
            disposables!!.dispose()
        }
    }
    //endregion

    //region functions

    fun <T> exec(observable: Observable<T>, disposable: DisposableObserver<T>): Observable<T> {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposable)
        addDisposable(disposable)
        return observable
    }

    private fun addDisposable(disposable: Disposable) {
        if (disposables == null) {
            disposables = CompositeDisposable()
        }
        disposables!!.add(disposable)
    }
    //endregion
}
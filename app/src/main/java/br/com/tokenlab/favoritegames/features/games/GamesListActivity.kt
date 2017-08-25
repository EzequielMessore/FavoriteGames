package br.com.tokenlab.favoritegames.features.games

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import br.com.tokenlab.favoritegames.R
import br.com.tokenlab.favoritegames.data.entities.Game
import br.com.tokenlab.favoritegames.data.model.impl.GamesModelImpl
import br.com.tokenlab.favoritegames.features.base.view.BaseActivity
import br.com.tokenlab.favoritegames.features.base.view.ViewPresenter
import br.com.tokenlab.favoritegames.features.base.view.dialog.ProgressDialog
import br.com.tokenlab.favoritegames.utils.AppUtil
import kotlinx.android.synthetic.main.activity_gameslist.*

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
class GamesListActivity : BaseActivity(), GamesContract.View, ViewPresenter<GamesContract.Presenter> {

    override lateinit var presenter: GamesContract.Presenter
    private lateinit var adapter: GamesListAdapter
    private lateinit var dialogFragment: ProgressDialog

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameslist)
        setSupportActionBar(toolbar)
    }

    //endregion

    //region #GamesContract.View

    override fun load(list: List<Game>) {
        adapter.items = list
    }

    //endregion

    //region Override

    override fun init(savedInstanceState: Bundle?) {
        recyclerView.adapter = adapter
        presenter.list()
    }

    override fun setUp(savedInstanceState: Bundle?) {
        super.setUp(savedInstanceState)
        presenter = GamesPresenter(GamesModelImpl())
        val listener = object : GamesListAdapter.OnGameClickListener {
            override fun onClick(games: Game) {
                Toast.makeText(this@GamesListActivity, "", Toast.LENGTH_LONG).show()
            }
        }
        adapter = GamesListAdapter(listener)
        dialogFragment = ProgressDialog()
    }

    //endregion

    //region #LoadingView
    override fun showError(error: Throwable) {
        Toast.makeText(this, R.string.msg_error_loading, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        dialogFragment.show(supportFragmentManager, GamesListActivity::class.java.simpleName)
    }

    override fun hideLoading() {
        dialogFragment.dismiss()
    }
    //endregion

    //static method
    companion object {
        fun getIntent(context: Context): Intent
                = AppUtil.startActivityAndFinishPrevious(context,GamesListActivity::class.java)
    }

}
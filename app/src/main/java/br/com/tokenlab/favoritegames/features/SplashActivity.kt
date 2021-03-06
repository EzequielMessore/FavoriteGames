package br.com.tokenlab.favoritegames.features

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import br.com.tokenlab.favoritegames.R
import br.com.tokenlab.favoritegames.features.games.GamesListActivity

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME = 1000L
    private val mHandler = Handler()
    private val mSplashRunnable = Runnable {
        startActivity(GamesListActivity.getIntent(this))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        mHandler.postDelayed(mSplashRunnable, SPLASH_TIME)
    }

    override fun onPause() {
        mHandler.removeCallbacks(mSplashRunnable)
        super.onPause()
    }

}
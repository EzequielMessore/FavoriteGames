package br.com.tokenlab.favoritegames

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by Ezequiel Messore on 23/08/2017.
 * ezequielmessore.developer@gmail.com
 */
class FavoriteApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}
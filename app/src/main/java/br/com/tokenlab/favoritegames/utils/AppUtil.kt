package br.com.tokenlab.favoritegames.utils

import android.app.Activity
import android.content.Context
import android.content.Intent


/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
object AppUtil {
    fun startActivityAndFinishPrevious(context: Context, activity: Class<out Activity>): Intent {
        return Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    }
}
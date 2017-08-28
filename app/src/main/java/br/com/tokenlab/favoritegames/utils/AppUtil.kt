package br.com.tokenlab.favoritegames.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
object AppUtil {

    private val LOCALE_PT_BR = Locale("pt", "BR")
    private val PATTERN_DATE = "dd/MM/yyyy"

    fun startActivityAndFinishPrevious(context: Context, activity: Class<out Activity>): Intent {
        return Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    }

    fun formatDate(date: Date): String {
        return format(date, AppUtil.PATTERN_DATE)
    }

    private fun format(date: Date, pattern: String): String {
        val dateTimeFormat = SimpleDateFormat(pattern, LOCALE_PT_BR)
        return dateTimeFormat.format(date)
    }
}
package br.com.tokenlab.favoritegames.features.base.view.dialog

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.tokenlab.favoritegames.R

/**
 * Created by ezequiel.messore on 25/ago/2017.
 * ezequiel.messore@guaranisistemas.com.br
 */
class ProgressDialog : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_progress, container, false)
    }

}
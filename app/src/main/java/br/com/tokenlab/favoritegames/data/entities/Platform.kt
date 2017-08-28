package br.com.tokenlab.favoritegames.data.entities

import br.com.tokenlab.favoritegames.R

/**
 * Created by Ezequiel Messore on 26/08/2017.
 * ezequielmessore.developer@gmail.com
 */
enum class Platform {
    X360 {
        override fun getMipmap() = R.mipmap.ic_xbox_360
    },
    XONE {
        override fun getMipmap() = R.mipmap.ic_xone
    },
    PS3 {
        override fun getMipmap() = R.mipmap.ic_ps3
    },
    PS4 {
        override fun getMipmap() = R.mipmap.ic_ps4
    },
    NS {
        override fun getMipmap() = R.mipmap.ic_ns
    },
    LNX {
        override fun getMipmap() = R.mipmap.ic_linux
    },
    Android {
        override fun getMipmap() = R.mipmap.ic_android
    },
    iOS {
        override fun getMipmap() = R.mipmap.ic_apple
    },
    PC {
        override fun getMipmap() = R.mipmap.ic_windows
    },
    MAC {
        override fun getMipmap() = R.mipmap.ic_mac
    };

    abstract fun getMipmap(): Int
}
package it.marcosignoretto.themoviedbbrowser.di.subcomponent

import android.support.v7.widget.RecyclerView

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 23/02/2018.
 */
interface ViewHolderInjectable<T : RecyclerView.ViewHolder> {
    fun injectTo(target: T)
}
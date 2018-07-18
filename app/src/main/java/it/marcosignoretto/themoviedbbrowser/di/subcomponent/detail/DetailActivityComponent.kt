package it.marcosignoretto.themoviedbbrowser.di.subcomponent.detail

import dagger.Subcomponent
import it.marcosignoretto.themoviedbbrowser.di.scope.ActivityScope
import it.marcosignoretto.themoviedbbrowser.presentation.screen.detail.DetailActivity

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@ActivityScope
@Subcomponent(modules = [DetailActivityModule::class])
interface DetailActivityComponent {
    fun injectTo(target: DetailActivity)
}
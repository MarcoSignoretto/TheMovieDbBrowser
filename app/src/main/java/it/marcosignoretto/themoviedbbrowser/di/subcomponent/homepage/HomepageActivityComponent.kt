package it.marcosignoretto.themoviedbbrowser.di.subcomponent.homepage

import dagger.Subcomponent
import it.marcosignoretto.themoviedbbrowser.di.scope.ActivityScope
import it.marcosignoretto.themoviedbbrowser.di.subcomponent.ViewHolderInjectable
import it.marcosignoretto.themoviedbbrowser.presentation.adapter.MovieListAdapter
import it.marcosignoretto.themoviedbbrowser.presentation.screen.homepage.HomepageActivity
import it.marcosignoretto.themoviedbbrowser.presentation.screen.homepage.MovieListItemViewHolder

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@ActivityScope
@Subcomponent(modules = [HomepageActivityModule::class])
interface HomepageActivityComponent : ViewHolderInjectable<MovieListItemViewHolder> {

    fun injectTo(target: HomepageActivity)

    override fun injectTo(target: MovieListItemViewHolder)

    fun injectTo(target: MovieListAdapter<HomepageActivityComponent>)

}
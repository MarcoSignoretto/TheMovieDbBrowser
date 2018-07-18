package it.marcosignoretto.themoviedbbrowser.presentation.interactor

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.data.model.Movie

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 22/02/2018.
 */
interface RefreshMoviesInteractor {
    fun execute() : Observable<List<Movie>>
}
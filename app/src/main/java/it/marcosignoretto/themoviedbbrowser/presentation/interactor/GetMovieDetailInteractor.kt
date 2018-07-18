package it.marcosignoretto.themoviedbbrowser.presentation.interactor

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.data.model.MovieDetail

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 22/02/2018.
 */
interface GetMovieDetailInteractor {
    fun execute(movieId: Int): Observable<MovieDetail>
}
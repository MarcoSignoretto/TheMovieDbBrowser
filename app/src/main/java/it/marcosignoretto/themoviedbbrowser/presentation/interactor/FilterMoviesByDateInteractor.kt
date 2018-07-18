package it.marcosignoretto.themoviedbbrowser.presentation.interactor

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.data.model.Movie
import java.util.*

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 22/02/2018.
 */
interface FilterMoviesByDateInteractor {
    fun execute(date : Date) : Observable<List<Movie>>
}
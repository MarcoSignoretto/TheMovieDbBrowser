package it.marcosignoretto.themoviedbbrowser.business.interactor

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.business.repository.MovieRepository
import it.marcosignoretto.themoviedbbrowser.data.model.Movie
import it.marcosignoretto.themoviedbbrowser.presentation.interactor.FilterMoviesByDateInteractor
import java.util.*
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
class FilterMoviesByDateInteractorImpl @Inject constructor(
        private val movieRepository: MovieRepository
) : FilterMoviesByDateInteractor {
    override fun execute(date : Date) : Observable<List<Movie>>{

        return movieRepository.getMoviesFilteredByDate(date).flatMap {
            Observable.just(it.sortedWith(compareByDescending<Movie> { it.releaseDate }.thenByDescending { it.id }))
        }
    }

}
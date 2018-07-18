package it.marcosignoretto.themoviedbbrowser.business.interactor

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.business.repository.MovieRepository
import it.marcosignoretto.themoviedbbrowser.data.model.Movie
import it.marcosignoretto.themoviedbbrowser.presentation.interactor.RefreshMoviesInteractor
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
class RefreshMoviesInteractorImpl @Inject constructor(
        private val movieRepository: MovieRepository
) : RefreshMoviesInteractor {

    override fun execute() : Observable<List<Movie>> {

        return movieRepository.reloadMovies().flatMap {
            Observable.just(it.sortedWith(compareByDescending<Movie> { it.releaseDate }.thenByDescending { it.id }))
        }
    }
}
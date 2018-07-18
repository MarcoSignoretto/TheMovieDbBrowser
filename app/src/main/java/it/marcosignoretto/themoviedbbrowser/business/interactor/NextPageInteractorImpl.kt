package it.marcosignoretto.themoviedbbrowser.business.interactor

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.business.repository.MovieRepository
import it.marcosignoretto.themoviedbbrowser.data.model.Movie
import it.marcosignoretto.themoviedbbrowser.presentation.interactor.NextPageInteractor
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 17/02/2018.
 */
class NextPageInteractorImpl @Inject constructor(
        private val movieRepository: MovieRepository
) : NextPageInteractor {

    override fun execute() : Observable<List<Movie>> {
        return movieRepository.getNextPage().flatMap {
            Observable.just(it.sortedWith(compareByDescending<Movie> { it.releaseDate }.thenByDescending { it.id }))
        }
    }
}
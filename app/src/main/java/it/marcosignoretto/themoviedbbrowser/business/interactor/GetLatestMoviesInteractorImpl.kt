package it.marcosignoretto.themoviedbbrowser.business.interactor

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.business.repository.MovieRepository
import it.marcosignoretto.themoviedbbrowser.data.model.Movie
import it.marcosignoretto.themoviedbbrowser.presentation.interactor.GetLatestMoviesInteractor
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
class GetLatestMoviesInteractorImpl @Inject constructor(
        private val movieRepository: MovieRepository
) : GetLatestMoviesInteractor {


    override fun execute() : Observable<List<Movie>>{
        return movieRepository.getLatestMovieList().flatMap {
            Observable.just(it.sortedWith(compareByDescending<Movie> { it.releaseDate }.thenByDescending { it.id }))
        }
    }



}
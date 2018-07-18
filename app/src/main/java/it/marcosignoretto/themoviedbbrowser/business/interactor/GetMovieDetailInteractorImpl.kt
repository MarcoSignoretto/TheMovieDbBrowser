package it.marcosignoretto.themoviedbbrowser.business.interactor

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.business.repository.MovieRepository
import it.marcosignoretto.themoviedbbrowser.data.model.MovieDetail
import it.marcosignoretto.themoviedbbrowser.presentation.interactor.GetMovieDetailInteractor
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 18/02/2018.
 */
class GetMovieDetailInteractorImpl @Inject constructor(
        private val movieRepository: MovieRepository
) : GetMovieDetailInteractor {
    override fun execute(movieId: Int): Observable<MovieDetail> {
        return movieRepository.getMovie(movieId)
    }
}
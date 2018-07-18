package it.marcosignoretto.themoviedbbrowser.business.repository

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.data.model.Movie
import it.marcosignoretto.themoviedbbrowser.data.model.MovieDetail
import java.util.*

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
interface MovieRepository {

    fun getLatestMovieList(page: Int = 1) : Observable<List<Movie>>
    fun getNextPage() : Observable<List<Movie>>
    fun getMovie(movieId: Int) : Observable<MovieDetail>
    fun getMoviesFilteredByDate(date: Date, page : Int = 1): Observable<List<Movie>>
    fun reloadMovies() :  Observable<List<Movie>>
}
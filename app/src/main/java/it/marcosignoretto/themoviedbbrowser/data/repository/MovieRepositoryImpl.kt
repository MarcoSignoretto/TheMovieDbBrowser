package it.marcosignoretto.themoviedbbrowser.data.repository

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.business.repository.MovieRepository
import it.marcosignoretto.themoviedbbrowser.data.mapper.MovieDetailMapper
import it.marcosignoretto.themoviedbbrowser.data.mapper.MovieMapper
import it.marcosignoretto.themoviedbbrowser.data.model.Movie
import it.marcosignoretto.themoviedbbrowser.data.model.MovieDetail
import it.marcosignoretto.themoviedbbrowser.data.network.response.MoviesListResponse
import it.marcosignoretto.themoviedbbrowser.data.network.service.movie.MovieDetailWebService
import it.marcosignoretto.themoviedbbrowser.data.network.service.movie.MoviesListWebService
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@Singleton
class MovieRepositoryImpl @Inject constructor(
        private val moviesListWebService: MoviesListWebService,
        private val movieDetailWebService: MovieDetailWebService,
        private val movieMapper: MovieMapper,
        private val movieDetailMapper: MovieDetailMapper
        ) : MovieRepository {


    private var nextPage = 1
    private var filterDate : Date? = null


    override fun reloadMovies() :  Observable<List<Movie>>{
        return loadMovies(1)
    }

    override fun getNextPage() : Observable<List<Movie>>{
        return loadMovies(nextPage)
    }

    private fun loadMovies(page : Int) : Observable<List<Movie>>{
        return if(page>0){
            if(filterDate == null){
                getLatestMovieList(page)
            }else{
                getMoviesFilteredByDate(filterDate!!,page)
            }
        }else{
            Observable.empty<List<Movie>>()
        }
    }

    override fun getLatestMovieList(page: Int) : Observable<List<Movie>>{
        var pg = page
        if(filterDate!=null)pg = 1
        filterDate = null
        return moviesListWebService.getMoviesList(page = pg)
                .flatMap {
                    nextPageLogic(it,pg)
                }
    }

    override fun getMovie(movieId: Int) : Observable<MovieDetail>{
        return movieDetailWebService.getMovie(movieId).map { movieDetailMapper.transformFromMovieDetailResponse(it) }
    }

    override fun getMoviesFilteredByDate(date: Date, page : Int): Observable<List<Movie>> {
        var pg = page
        if(filterDate==null)pg = 1
        filterDate = date
        return moviesListWebService.getMoviesList(primaryReleaseDateLte = date, primaryReleaseDateGte = date, releaseDateLte = date, releaseDateGte = date, page = pg)
                .flatMap {
                    nextPageLogic(it,pg)
                }

    }


    private fun nextPageLogic(it: MoviesListResponse, page : Int) : Observable<List<Movie>> {
        it.total_pages?.let {
            nextPage = if(it >= page + 1) page + 1 else -1 // This allows to reset if reload first page and block next page if end of results
        }
        return Observable.just(movieMapper.transformFromMovieListResults(it.results))
    }



}
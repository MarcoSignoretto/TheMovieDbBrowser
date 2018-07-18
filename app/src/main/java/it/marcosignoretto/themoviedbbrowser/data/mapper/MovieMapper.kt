package it.marcosignoretto.themoviedbbrowser.data.mapper

import it.marcosignoretto.themoviedbbrowser.data.model.Movie
import it.marcosignoretto.themoviedbbrowser.data.network.subitems.MovieListResult
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
class MovieMapper @Inject constructor(){

    fun transformFromMovieListResults(wsMovies: List<MovieListResult>) : List<Movie> = wsMovies.map { transformFromMovieListResult(it) }

    fun transformFromMovieListResult(wsMovie : MovieListResult) : Movie {
        return Movie(
                wsMovie.id,
                wsMovie.title,
                wsMovie.overview,
                wsMovie.releaseDate,
                wsMovie.posterPath
        )
    }


}
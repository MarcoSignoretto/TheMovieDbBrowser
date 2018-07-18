package it.marcosignoretto.themoviedbbrowser.presentation.mapper
import it.marcosignoretto.themoviedbbrowser.data.model.Movie
import it.marcosignoretto.themoviedbbrowser.presentation.model.UIMovie
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
class UIMovieMapper @Inject constructor() {

    fun transformFromMovies(movies: List<Movie>) : List<UIMovie> = movies.map { transformFromMovie(it) }

    fun transformFromMovie(movie : Movie) : UIMovie {
        return UIMovie(
                movie.id,
                movie.title,
                movie.overview,
                movie.releaseDate,
                movie.posterPath
        )
    }


}
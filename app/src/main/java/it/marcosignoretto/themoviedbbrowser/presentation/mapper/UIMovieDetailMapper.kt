package it.marcosignoretto.themoviedbbrowser.presentation.mapper

import it.marcosignoretto.themoviedbbrowser.data.model.MovieDetail
import it.marcosignoretto.themoviedbbrowser.presentation.model.UIMovieDetail
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
class UIMovieDetailMapper @Inject constructor() {

    fun transformFromMovieDetail(movieDetail : MovieDetail) : UIMovieDetail {
        return UIMovieDetail(
                movieDetail.adult,
                movieDetail.genres,
                movieDetail.homepage,
                movieDetail.id,
                movieDetail.imdbId,
                movieDetail.originalLanguage,
                movieDetail.originalTitle,
                movieDetail.overview,
                movieDetail.popularity,
                movieDetail.posterPath,
                movieDetail.productionCompanies,
                movieDetail.productionCountries,
                movieDetail.releaseDate,
                movieDetail.revenue,
                movieDetail.runtime,
                movieDetail.spokenLanguages,
                movieDetail.status,
                movieDetail.tagline,
                movieDetail.title,
                movieDetail.video,
                movieDetail.voteAverage,
                movieDetail.voteCount
        )
    }

}
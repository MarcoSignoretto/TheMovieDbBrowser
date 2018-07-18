package it.marcosignoretto.themoviedbbrowser.data.mapper


import it.marcosignoretto.themoviedbbrowser.data.model.MovieDetail
import it.marcosignoretto.themoviedbbrowser.data.network.response.MovieDetailResponse
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
class MovieDetailMapper @Inject constructor(
        val stringMapper: StringMapper
) {

    fun transformFromMovieDetailResponse(wsMovieDetail : MovieDetailResponse) : MovieDetail {
        return MovieDetail(
                wsMovieDetail.adult,
                stringMapper.transformFromGenres(wsMovieDetail.genres),
                wsMovieDetail.homepage,
                wsMovieDetail.id,
                wsMovieDetail.imdbId,
                wsMovieDetail.originalLanguage,
                wsMovieDetail.originalTitle,
                wsMovieDetail.overview,
                wsMovieDetail.popularity,
                wsMovieDetail.posterPath,
                stringMapper.transformFromProductionCompanies(wsMovieDetail.productionCompanies),
                stringMapper.transformFromProductionCountries(wsMovieDetail.productionCountries),
                wsMovieDetail.releaseDate,
                wsMovieDetail.revenue,
                wsMovieDetail.runtime,
                stringMapper.transformFromSpokenLanguages(wsMovieDetail.spokenLanguages),
                wsMovieDetail.status,
                wsMovieDetail.tagline,
                wsMovieDetail.title,
                wsMovieDetail.video,
                wsMovieDetail.voteAverage,
                wsMovieDetail.voteCount
        )
    }



}
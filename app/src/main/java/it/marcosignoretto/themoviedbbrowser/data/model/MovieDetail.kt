package it.marcosignoretto.themoviedbbrowser.data.model

import java.util.*

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
data class MovieDetail(
        var adult : Boolean?,
        var genres : List<String>,
        var homepage : String?,
        var id : Int?,
        var imdbId : String?,
        var originalLanguage : String?,
        var originalTitle : String?,
        var overview : String?,
        var popularity : Double?,
        var posterPath : String?,
        var productionCompanies : List<String>,
        var productionCountries : List<String>,
        var releaseDate : Date?,
        var revenue : Int?,
        var runtime : Int?,
        var spokenLanguages : List<String>,
        var status : String?,
        var tagline : String?,
        var title : String?,
        var video : Boolean?,
        var voteAverage : Double?,
        var voteCount : Int?
)

package it.marcosignoretto.themoviedbbrowser.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import it.marcosignoretto.themoviedbbrowser.data.network.subitems.Genres
import it.marcosignoretto.themoviedbbrowser.data.network.subitems.ProductionCompany
import it.marcosignoretto.themoviedbbrowser.data.network.subitems.ProductionCountry
import it.marcosignoretto.themoviedbbrowser.data.network.subitems.SpokenLanguage
import java.util.*

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 18/02/2018.
 */
class MovieDetailResponse {

    @Expose
    @SerializedName("adult")
    var adult : Boolean? = null

    @Expose
    @SerializedName("genres")
    var genres = ArrayList<Genres>()

    @Expose
    @SerializedName("homepage")
    var homepage : String? = null

    @Expose
    @SerializedName("id")
    var id : Int? = null

    @Expose
    @SerializedName("imdb_id")
    var imdbId : String? = null

    @Expose
    @SerializedName("original_language")
    var originalLanguage : String? = null

    @Expose
    @SerializedName("original_title")
    var originalTitle : String? = null

    @Expose
    @SerializedName("overview")
    var overview : String? = null

    @Expose
    @SerializedName("popularity")
    var popularity : Double? = null
    @Expose
    @SerializedName("poster_path")
    var posterPath : String? = null

    @Expose
    @SerializedName("production_companies")
    var productionCompanies = ArrayList<ProductionCompany>()

    @Expose
    @SerializedName("production_countries")
    var productionCountries = ArrayList<ProductionCountry>()

    @Expose
    @SerializedName("release_date")
    var releaseDate : Date? = null

    @Expose
    @SerializedName("revenue")
    var revenue : Int? = null

    @Expose
    @SerializedName("runtime")
    var runtime : Int? = null

    @Expose
    @SerializedName("spoken_languages")
    var spokenLanguages = ArrayList<SpokenLanguage>()

    @Expose
    @SerializedName("status")
    var status : String? = null

    @Expose
    @SerializedName("tagline")
    var tagline : String? = null

    @Expose
    @SerializedName("title")
    var title : String? = null

    @Expose
    @SerializedName("video")
    var video : Boolean? = null

    @Expose
    @SerializedName("vote_average")
    var voteAverage : Double? = null

    @Expose
    @SerializedName("vote_count")
    var voteCount : Int? = null
}
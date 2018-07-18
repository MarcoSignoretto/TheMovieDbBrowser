package it.marcosignoretto.themoviedbbrowser.data.network.subitems

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */

class MovieListResult {

    @Expose
    @SerializedName("poster_path")
    var posterPath : String? = null

    @Expose
    @SerializedName("adult")
    var adult : Boolean? = null


    @Expose
    @SerializedName("overview")
    var overview : String? = null

    @Expose
    @SerializedName("release_date")
    var releaseDate : Date? = null

    @Expose
    @SerializedName("genre_ids")
    var genreIds = ArrayList<Int>()

    @Expose
    @SerializedName("id")
    var id : Int?  = null

    @Expose
    @SerializedName("original_title")
    var originalTitle : String?  = null

    @Expose
    @SerializedName("original_language")
    var originalLanguage : String?  = null

    @Expose
    @SerializedName("title")
    var title : String?  = null

    @Expose
    @SerializedName("backdrop_path")
    var backdropPath : String?  = null

    @Expose
    @SerializedName("popularity")
    var popularity : Double?  = null

    @Expose
    @SerializedName("vote_count")
    var voteCount : Int?  = null

    @Expose
    @SerializedName("video")
    var video : Boolean?  = null

    @Expose
    @SerializedName("vote_average")
    var voteAverage : Double?  = null

}
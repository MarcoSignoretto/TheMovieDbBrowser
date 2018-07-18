package it.marcosignoretto.themoviedbbrowser.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import it.marcosignoretto.themoviedbbrowser.data.network.subitems.MovieListResult

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
class MoviesListResponse {

    @Expose
    @SerializedName("page")
    var page : Int? = null

    @Expose
    @SerializedName("results")
    var results = ArrayList<MovieListResult>()

    @Expose
    @SerializedName("total_results")
    var total_results : Int? = null

    @Expose
    @SerializedName("total_pages")
    var total_pages : Int? = null

}
package it.marcosignoretto.themoviedbbrowser.data.network.service.movie

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.data.network.response.MoviesListResponse
import it.marcosignoretto.themoviedbbrowser.di.qualifier.ApiKey
import it.marcosignoretto.themoviedbbrowser.di.qualifier.AppLanguage
import it.marcosignoretto.themoviedbbrowser.di.qualifier.WsDateFormat
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import java.text.DateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
class MoviesListWebService @Inject constructor(
        private val retrofit : Retrofit,
        @ApiKey private val apiKey: String,
        @AppLanguage private val language: String,
        @WsDateFormat private val dateFormat : DateFormat
){

    object Sort{
        const val PRIMARY_RELEASE_DATE_DESC = "primary_release_date.desc"
        const val RELEASE_DATE_DESC = "release_date.desc"
    }


    interface MoviesList {


        @GET("discover/movie")
        fun getMoviesList(
            @Query("primary_release_date.lte") primaryReleaseDateLte : String,
            @Query("primary_release_date.gte") primaryReleaseDateGte : String?,
            @Query("release_date.lte") releaseDateLte : String?,
            @Query("release_date.gte") releaseDateGte : String?,
            @Query("api_key") apiKey : String,
            @Query("sort_by") sortBy : String,
            @Query("page") page : Int,
            @Query("language") language : String

        ) : Observable<MoviesListResponse>
    }

    fun getMoviesList(
            primaryReleaseDateLte : Date = Date(),
            primaryReleaseDateGte : Date? = null,
            releaseDateLte : Date? = null,
            releaseDateGte : Date? = null,
            apiKey: String = this.apiKey,
            sortBy: String = Sort.RELEASE_DATE_DESC,
            page : Int = 1,
            language: String = this.language
    ) : Observable<MoviesListResponse>{
        val api = retrofit.create(MoviesListWebService.MoviesList::class.java)
        return api.getMoviesList(
                dateFormat.format(primaryReleaseDateLte),
                if(releaseDateLte != null) dateFormat.format(releaseDateLte) else null,
                if(releaseDateGte != null)dateFormat.format(releaseDateGte) else null,
                if(primaryReleaseDateGte != null)dateFormat.format(primaryReleaseDateGte) else null,
                apiKey,
                sortBy,
                page,
                language
        )
    }

}
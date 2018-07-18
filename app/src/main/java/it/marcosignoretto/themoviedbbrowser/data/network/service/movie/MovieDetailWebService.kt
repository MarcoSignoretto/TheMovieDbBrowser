package it.marcosignoretto.themoviedbbrowser.data.network.service.movie

import io.reactivex.Observable
import it.marcosignoretto.themoviedbbrowser.data.network.response.MovieDetailResponse
import it.marcosignoretto.themoviedbbrowser.di.qualifier.ApiKey
import it.marcosignoretto.themoviedbbrowser.di.qualifier.AppLanguage
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 18/02/2018.
 */
class MovieDetailWebService @Inject constructor(
        private val retrofit : Retrofit,
        @ApiKey private val apiKey : String,
        @AppLanguage private val language : String
) {


    interface MovieDetail {

        @GET("movie/{movie_id}")
        fun getMovieDetail(
                @Path("movie_id") movieId : Int,
                @Query("api_key") apiKey : String,
                @Query("language") language : String
        ) : Observable<MovieDetailResponse>
    }

    fun getMovie(movieId : Int) : Observable<MovieDetailResponse> {
        val api = retrofit.create(MovieDetailWebService.MovieDetail::class.java)
        return api.getMovieDetail(
                movieId,
                apiKey,
                language
        )
    }

}
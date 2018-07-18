package it.marcosignoretto.themoviedbbrowser

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */


object AppConfig {

    const val API_KEY = "afd69d063d096dd788595b1f78ba95fe"

    object WebService{
        const val BASE_API_URL = "https://api.themoviedb.org/3/"
        const val TIMEOUT_DEFAULT_SECONDS = 8
        const val BASE_POSTER_PATH = "http://image.tmdb.org/t/p/"
        const val DETAIL_RESOLUTION = "w780"
        const val LIST_RESOLUTION = "w185"
    }
}
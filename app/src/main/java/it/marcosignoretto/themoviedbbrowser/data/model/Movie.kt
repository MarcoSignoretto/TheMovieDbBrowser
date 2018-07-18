package it.marcosignoretto.themoviedbbrowser.data.model
import java.util.*

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
data class Movie(
        val id : Int?,
        val title : String?,
        val overview : String?,
        val releaseDate : Date?,
        val posterPath : String?
)
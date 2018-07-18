package it.marcosignoretto.themoviedbbrowser.presentation.model

import java.util.*

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
data class UIMovie(
    val id : Int?,
    val title : String?,
    val overview : String?,
    val releaseDate : Date?,
    val posterPath : String?
)
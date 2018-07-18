package it.marcosignoretto.themoviedbbrowser.data.network.subitems

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 18/02/2018.
 */
class SpokenLanguage {


    @Expose
    @SerializedName("iso_639_1")
    var iso_639_1 : String? = null

    @Expose
    @SerializedName("name")
    var name : String? = null
}
package it.marcosignoretto.themoviedbbrowser.data.network.subitems

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 18/02/2018.
 */
class ProductionCountry {
    @Expose
    @SerializedName("name")
    var name : String? = null

    @Expose
    @SerializedName("iso_3166_1")
    var iso3166_1 : String? = null
}

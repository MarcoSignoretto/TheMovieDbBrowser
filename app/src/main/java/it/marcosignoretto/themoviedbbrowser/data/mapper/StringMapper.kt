package it.marcosignoretto.themoviedbbrowser.data.mapper

import android.text.TextUtils
import it.marcosignoretto.themoviedbbrowser.data.network.subitems.Genres
import it.marcosignoretto.themoviedbbrowser.data.network.subitems.ProductionCompany
import it.marcosignoretto.themoviedbbrowser.data.network.subitems.ProductionCountry
import it.marcosignoretto.themoviedbbrowser.data.network.subitems.SpokenLanguage
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
class StringMapper @Inject constructor() {
    fun transformFromProductionCompanies(productCompanies : List<ProductionCompany>) : List<String> = productCompanies.map { transformFromProductionCompany(it) }.filter { !TextUtils.isEmpty(it) }
    fun transformFromProductionCompany(productCompany : ProductionCompany) : String = productCompany.name ?: ""

    fun transformFromProductionCountries(productCountries : List<ProductionCountry>) : List<String> = productCountries.map { transformFromProductionCountry(it) }.filter { !TextUtils.isEmpty(it) }
    fun transformFromProductionCountry(productCountry : ProductionCountry) : String = productCountry.iso3166_1 ?: ""

    fun transformFromSpokenLanguages(spokenLanguages : List<SpokenLanguage>) : List<String> = spokenLanguages.map { transformFromSpokenLanguage(it) }.filter { !TextUtils.isEmpty(it) }
    fun transformFromSpokenLanguage(spokenLanguage : SpokenLanguage) : String = spokenLanguage.iso_639_1 ?: ""

    fun transformFromGenres(genres : List<Genres>) : List<String> = genres.map { transformFromGenre(it) }.filter { !TextUtils.isEmpty(it) }
    fun transformFromGenre(genre : Genres) : String = genre.name ?: ""
}
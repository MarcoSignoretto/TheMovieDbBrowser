package it.marcosignoretto.themoviedbbrowser.presentation.screen.homepage

import it.marcosignoretto.themoviedbbrowser.presentation.model.UIMovie

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
interface HomepageView {
    fun startLoading()
    fun stopLoading()
    fun showResults(results: List<UIMovie>)
    fun addResults(results: List<UIMovie>)
    fun showDatePiker()
    fun showResetFilterButton()
    fun hideResetFilterButton()

    fun showEmptyView()
    fun clearResults()
    fun showFatalErrorView()
    fun hideErrorViews()
    fun showGenericError()
    fun hideEmptyList()
}
package it.marcosignoretto.themoviedbbrowser.presentation.screen.detail

import it.marcosignoretto.themoviedbbrowser.presentation.model.UIMovieDetail

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
interface DetailView {
    fun startLoading()
    fun stopLoading()
    fun showDetail(result: UIMovieDetail)
    fun showErrorView()
    fun hideErrorView()
    fun showDetailView()
    fun hideDetailView()
}
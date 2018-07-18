package it.marcosignoretto.themoviedbbrowser.presentation.presenter

import it.marcosignoretto.themoviedbbrowser.presentation.navigator.Navigator

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
abstract class BasePresenter(private val navigator: Navigator) {
    fun goBack() {
        navigator.navigateBack()
    }

}
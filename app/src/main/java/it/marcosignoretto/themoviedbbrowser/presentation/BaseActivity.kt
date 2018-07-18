package it.marcosignoretto.themoviedbbrowser.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
    }

    abstract fun injectDependencies()
}
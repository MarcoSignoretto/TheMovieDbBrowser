package it.marcosignoretto.themoviedbbrowser

import android.app.Application
import it.marcosignoretto.themoviedbbrowser.di.*

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
class MovieApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = initDagger(this)
    }

    private fun initDagger(app: MovieApplication) : AppComponent{

        return DaggerAppComponent.builder()
                .appModule(AppModule(app))
                .build()
    }
}
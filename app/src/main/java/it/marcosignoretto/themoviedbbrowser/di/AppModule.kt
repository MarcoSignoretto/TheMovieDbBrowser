package it.marcosignoretto.themoviedbbrowser.di

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.Module
import dagger.Provides
import it.marcosignoretto.themoviedbbrowser.di.qualifier.AppLanguage
import it.marcosignoretto.themoviedbbrowser.di.qualifier.AppLocale
import it.marcosignoretto.themoviedbbrowser.di.qualifier.UIDateFormat
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@Module
class AppModule(private val app: Application) {

    init {
        Fresco.initialize(app)
    }

    @Provides
    @Singleton
    fun providesContext(): Context = app

    @Provides
    @Singleton
    @UIDateFormat
    fun providesUIDateFormat(@AppLocale appLocale: Locale) : DateFormat = SimpleDateFormat("MMMM dd, yyyy", appLocale)

    @Provides
    @AppLocale
    fun providesAppLocale() : Locale = Locale.getDefault()

    @Provides
    @AppLanguage
    fun providesLanguage(@AppLocale appLocale: Locale) : String = appLocale.language

}
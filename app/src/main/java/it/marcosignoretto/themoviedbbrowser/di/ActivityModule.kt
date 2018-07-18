package it.marcosignoretto.themoviedbbrowser.di

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import it.marcosignoretto.themoviedbbrowser.di.scope.ActivityScope

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@Module
open class ActivityModule(val activity : Activity) {

    @Provides
    @ActivityScope
    fun providesActivity() : Activity = activity

    @Provides
    @ActivityScope
    fun providesActivityContext() : Context = activity.baseContext

}
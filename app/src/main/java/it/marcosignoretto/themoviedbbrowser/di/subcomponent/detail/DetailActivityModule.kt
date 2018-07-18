package it.marcosignoretto.themoviedbbrowser.di.subcomponent.detail

import dagger.Module
import dagger.Provides
import it.marcosignoretto.themoviedbbrowser.di.ActivityModule
import it.marcosignoretto.themoviedbbrowser.di.scope.ActivityScope
import it.marcosignoretto.themoviedbbrowser.presentation.screen.detail.DetailActivity
import it.marcosignoretto.themoviedbbrowser.presentation.screen.detail.DetailView

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@Module
class DetailActivityModule(activity: DetailActivity) : ActivityModule(activity) {

    @Provides
    @ActivityScope
    fun provideDetailView() : DetailView = activity as DetailActivity

}
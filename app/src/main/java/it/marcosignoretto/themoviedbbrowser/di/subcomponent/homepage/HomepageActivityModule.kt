package it.marcosignoretto.themoviedbbrowser.di.subcomponent.homepage

import dagger.Module
import dagger.Provides
import it.marcosignoretto.themoviedbbrowser.di.ActivityModule
import it.marcosignoretto.themoviedbbrowser.di.scope.ActivityScope
import it.marcosignoretto.themoviedbbrowser.presentation.screen.homepage.HomepageActivity
import it.marcosignoretto.themoviedbbrowser.presentation.screen.homepage.HomepageView

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@Module
class HomepageActivityModule(activity : HomepageActivity) : ActivityModule(activity) {

    @Provides
    @ActivityScope
    fun provideHomepageView() : HomepageView = activity as HomepageActivity
}
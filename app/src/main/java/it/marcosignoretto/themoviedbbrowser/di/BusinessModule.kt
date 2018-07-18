package it.marcosignoretto.themoviedbbrowser.di

import dagger.Module
import dagger.Provides
import it.marcosignoretto.themoviedbbrowser.business.interactor.*
import it.marcosignoretto.themoviedbbrowser.presentation.interactor.*

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@Module
class BusinessModule {

    @Provides
    fun providesGetLatestMoviesInteractor(impl : GetLatestMoviesInteractorImpl) : GetLatestMoviesInteractor = impl

    @Provides
    fun providesNextPageInteractor(impl : NextPageInteractorImpl) : NextPageInteractor = impl

    @Provides
    fun providesGetMovieDetailInteractor(impl : GetMovieDetailInteractorImpl) : GetMovieDetailInteractor = impl

    @Provides
    fun providesFilterMoviesByDateInteractor(impl : FilterMoviesByDateInteractorImpl) : FilterMoviesByDateInteractor = impl

    @Provides
    fun providesRefreshMoviesInteractor(impl : RefreshMoviesInteractorImpl) : RefreshMoviesInteractor = impl

}
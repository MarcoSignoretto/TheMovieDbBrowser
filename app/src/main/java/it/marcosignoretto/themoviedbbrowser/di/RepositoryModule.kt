package it.marcosignoretto.themoviedbbrowser.di

import dagger.Module
import dagger.Provides
import it.marcosignoretto.themoviedbbrowser.business.repository.MovieRepository
import it.marcosignoretto.themoviedbbrowser.data.repository.MovieRepositoryImpl

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@Module
class RepositoryModule {
    @Provides
    fun providesMovieRepository(impl: MovieRepositoryImpl) : MovieRepository = impl

}
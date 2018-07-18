package it.marcosignoretto.themoviedbbrowser.di

import dagger.Component
import it.marcosignoretto.themoviedbbrowser.di.subcomponent.detail.DetailActivityComponent
import it.marcosignoretto.themoviedbbrowser.di.subcomponent.detail.DetailActivityModule
import it.marcosignoretto.themoviedbbrowser.di.subcomponent.homepage.HomepageActivityComponent
import it.marcosignoretto.themoviedbbrowser.di.subcomponent.homepage.HomepageActivityModule
import javax.inject.Singleton

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@Singleton
@Component(modules = [AppModule::class, RepositoryModule::class, WebServiceModule::class, RxModule::class, BusinessModule::class])
interface AppComponent{

    fun plus(module: HomepageActivityModule) : HomepageActivityComponent
    fun plus(module: DetailActivityModule) : DetailActivityComponent

}
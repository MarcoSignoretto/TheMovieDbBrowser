package it.marcosignoretto.themoviedbbrowser.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import it.marcosignoretto.themoviedbbrowser.di.qualifier.IOScheduler
import it.marcosignoretto.themoviedbbrowser.di.qualifier.UiScheduler

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 17/02/2018.
 */
@Module
class RxModule {

    @Provides
    @UiScheduler
    fun providesUiScheduler() : Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @IOScheduler
    fun providesIOScheduler() : Scheduler = Schedulers.io()

}
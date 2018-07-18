package it.marcosignoretto.themoviedbbrowser.utils.factory

import io.reactivex.Scheduler
import it.marcosignoretto.themoviedbbrowser.di.qualifier.IOScheduler
import it.marcosignoretto.themoviedbbrowser.di.qualifier.UiScheduler
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 17/02/2018.
 */

/**
 * This class with RxModule allows to decouple Schedulers dependencies
 */
class RxSchedulerFactory @Inject constructor(
        @UiScheduler val uiScheduler: Scheduler,
        @IOScheduler val ioScheduler: Scheduler
)
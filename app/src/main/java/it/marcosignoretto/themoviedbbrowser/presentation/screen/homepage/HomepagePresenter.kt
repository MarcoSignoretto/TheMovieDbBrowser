package it.marcosignoretto.themoviedbbrowser.presentation.screen.homepage

import io.reactivex.rxkotlin.subscribeBy
import it.marcosignoretto.themoviedbbrowser.business.interactor.FilterMoviesByDateInteractorImpl
import it.marcosignoretto.themoviedbbrowser.business.interactor.GetLatestMoviesInteractorImpl
import it.marcosignoretto.themoviedbbrowser.business.interactor.NextPageInteractorImpl
import it.marcosignoretto.themoviedbbrowser.business.interactor.RefreshMoviesInteractorImpl
import it.marcosignoretto.themoviedbbrowser.di.scope.ActivityScope
import it.marcosignoretto.themoviedbbrowser.presentation.mapper.UIMovieMapper
import it.marcosignoretto.themoviedbbrowser.presentation.model.UIMovie
import it.marcosignoretto.themoviedbbrowser.presentation.navigator.Navigator
import it.marcosignoretto.themoviedbbrowser.presentation.presenter.BasePresenter
import it.marcosignoretto.themoviedbbrowser.utils.factory.RxSchedulerFactory
import java.lang.ref.WeakReference
import java.util.*
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@ActivityScope
class HomepagePresenter @Inject constructor(
        private val navigator : Navigator,
        homepageView: HomepageView,
        private val nextPageInteractor: NextPageInteractorImpl,
        private val getLatestMoviesInteractor: GetLatestMoviesInteractorImpl,
        private val filterMoviesByDateInteractor: FilterMoviesByDateInteractorImpl,
        private val refreshMoviesInteractor: RefreshMoviesInteractorImpl,
        private val rxSchedulerFactory: RxSchedulerFactory,
        private val uiMovieMapper: UIMovieMapper
) : BasePresenter(navigator) {

    private var homepageViewRef : WeakReference<HomepageView>

    init {
        homepageViewRef = WeakReference<HomepageView>(homepageView)
    }


    fun loadHomepage() {
        startLoadingOperations()
        getLatestMoviesInteractor.execute()
                .subscribeOn(rxSchedulerFactory.ioScheduler)
                .observeOn(rxSchedulerFactory.uiScheduler)
                .subscribeBy (
                    onNext = {
                        val results = uiMovieMapper.transformFromMovies(it)
                        if(results.isNotEmpty()){
                            homepageViewRef.get()?.showResults(results)
                        }else{
                            homepageViewRef.get()?.clearResults()
                            homepageViewRef.get()?.showEmptyView()
                        }
                    },
                    onComplete = {
                        homepageViewRef.get()?.stopLoading()
                    },
                    onError = {
                        homepageViewRef.get()?.stopLoading()
                        homepageViewRef.get()?.clearResults()
                        homepageViewRef.get()?.showFatalErrorView()
                    }
                )

    }

    fun reloadMovies() {
        startLoadingOperations()
        refreshMoviesInteractor.execute()
                .subscribeOn(rxSchedulerFactory.ioScheduler)
                .observeOn(rxSchedulerFactory.uiScheduler)
                .subscribeBy (
                        onNext = {
                            homepageViewRef.get()?.showResults(uiMovieMapper.transformFromMovies(it))
                        },
                        onComplete = {
                            homepageViewRef.get()?.stopLoading()
                        },
                        onError = {
                            homepageViewRef.get()?.stopLoading()
                            homepageViewRef.get()?.showGenericError()
                        }
                )
    }

    fun loadMoreData(){
        startLoadingOperations()
        nextPageInteractor.execute()
                .subscribeOn(rxSchedulerFactory.ioScheduler)
                .observeOn(rxSchedulerFactory.uiScheduler)
                .subscribeBy (
                        onNext = {
                            homepageViewRef.get()?.addResults(uiMovieMapper.transformFromMovies(it))
                        },
                        onComplete = {
                            homepageViewRef.get()?.stopLoading()
                        },
                        onError = {
                            homepageViewRef.get()?.stopLoading()
                            homepageViewRef.get()?.showGenericError()
                        }
                )
    }

    fun clickedOn(item: UIMovie) {
        navigator.navigateToMovieDetail(item)
    }

    fun showDatePicker() {
        homepageViewRef.get()?.showDatePiker()
    }

    fun filterByDate(date: Date) {
        startLoadingOperations()
        filterMoviesByDateInteractor.execute(date)
                .subscribeOn(rxSchedulerFactory.ioScheduler)
                .observeOn(rxSchedulerFactory.uiScheduler)
                .subscribeBy (
                        onNext = {
                            val results = uiMovieMapper.transformFromMovies(it)
                            if(results.isNotEmpty()){
                                homepageViewRef.get()?.showResults(results)
                            }else{
                                homepageViewRef.get()?.clearResults()
                                homepageViewRef.get()?.showEmptyView()
                            }
                            homepageViewRef.get()?.showResetFilterButton()
                        },
                        onComplete = {
                            homepageViewRef.get()?.stopLoading()
                        },
                        onError = {
                            homepageViewRef.get()?.stopLoading()
                            homepageViewRef.get()?.showGenericError()
                        }
                )

    }

    fun resetFilter() {
        startLoadingOperations()
        getLatestMoviesInteractor.execute()
                .subscribeOn(rxSchedulerFactory.ioScheduler)
                .observeOn(rxSchedulerFactory.uiScheduler)
                .subscribeBy (
                        onNext = {
                            val results = uiMovieMapper.transformFromMovies(it)
                            if(results.isNotEmpty()){
                                homepageViewRef.get()?.showResults(results)
                            }else{
                                homepageViewRef.get()?.clearResults()
                                homepageViewRef.get()?.showEmptyView()
                            }
                        },
                        onComplete = {
                            homepageViewRef.get()?.stopLoading()
                            homepageViewRef.get()?.hideResetFilterButton()
                        },
                        onError = {
                            homepageViewRef.get()?.stopLoading()

                            homepageViewRef.get()?.clearResults()
                            homepageViewRef.get()?.showFatalErrorView()
                        }
                )
    }

    private fun startLoadingOperations(){
        homepageViewRef.get()?.startLoading()
        homepageViewRef.get()?.hideErrorViews()
        homepageViewRef.get()?.hideEmptyList()
    }
}



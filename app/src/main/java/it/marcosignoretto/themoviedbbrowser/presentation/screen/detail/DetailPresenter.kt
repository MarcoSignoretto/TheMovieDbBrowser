package it.marcosignoretto.themoviedbbrowser.presentation.screen.detail

import io.reactivex.rxkotlin.subscribeBy
import it.marcosignoretto.themoviedbbrowser.business.interactor.GetMovieDetailInteractorImpl
import it.marcosignoretto.themoviedbbrowser.di.scope.ActivityScope
import it.marcosignoretto.themoviedbbrowser.presentation.mapper.UIMovieDetailMapper
import it.marcosignoretto.themoviedbbrowser.presentation.mapper.UIMovieMapper
import it.marcosignoretto.themoviedbbrowser.presentation.navigator.Navigator
import it.marcosignoretto.themoviedbbrowser.presentation.presenter.BasePresenter
import it.marcosignoretto.themoviedbbrowser.utils.factory.RxSchedulerFactory
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@ActivityScope
class DetailPresenter @Inject constructor(
        detailView: DetailView,
        private val navigator: Navigator,
        private val getMovieDetailInteractor: GetMovieDetailInteractorImpl,
        private val rxSchedulerFactory: RxSchedulerFactory,
        private val uiMovieMapper: UIMovieMapper,
        private val uiMovieDetailMapper: UIMovieDetailMapper
) : BasePresenter(navigator) {

    private var detailViewRef : WeakReference<DetailView>

    init {
        detailViewRef = WeakReference<DetailView>(detailView)
    }



    fun loadMovieWithId(id: Int) {

        detailViewRef.get()?.startLoading()
        detailViewRef.get()?.hideErrorView()
        getMovieDetailInteractor.execute(id)
                .subscribeOn(rxSchedulerFactory.ioScheduler)
                .observeOn(rxSchedulerFactory.uiScheduler)
                .subscribeBy (
                        onNext = {
                            detailViewRef.get()?.showDetail(uiMovieDetailMapper.transformFromMovieDetail(it))
                            detailViewRef.get()?.showDetailView()
                        },
                        onComplete = {
                            detailViewRef.get()?.stopLoading()
                        },
                        onError = {
                            detailViewRef.get()?.stopLoading()
                            detailViewRef.get()?.showErrorView()
                            detailViewRef.get()?.hideDetailView()

                        }
                )
    }


}
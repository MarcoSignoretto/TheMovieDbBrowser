package it.marcosignoretto.themoviedbbrowser.di

import dagger.Module
import dagger.Provides
import it.marcosignoretto.themoviedbbrowser.AppConfig
import it.marcosignoretto.themoviedbbrowser.BuildConfig
import it.marcosignoretto.themoviedbbrowser.di.qualifier.*
import it.marcosignoretto.themoviedbbrowser.utils.factory.RetrofitFactory
import retrofit2.Retrofit
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */
@Module
class WebServiceModule{

    @Provides
    fun providesRetrofit(@WsDateFormat wsDateFormat : DateFormat) : Retrofit = RetrofitFactory.createDefaultRxGsonRetrofit(
            AppConfig.WebService.BASE_API_URL,
            BuildConfig.DEBUG,
            AppConfig.WebService.TIMEOUT_DEFAULT_SECONDS,
            wsDateFormat
    )

    @Provides
    @ApiKey
    fun providesApiKey() : String = AppConfig.API_KEY

    @Provides
    @BasePosterPath
    fun providesBasePosterPath() : String = AppConfig.WebService.BASE_POSTER_PATH

    @Provides
    @ListPosterResolution
    fun providesListPosterResolution() : String = AppConfig.WebService.LIST_RESOLUTION

    @Provides
    @DetailPosterResolution
    fun providesDetailPosterResolution() : String = AppConfig.WebService.DETAIL_RESOLUTION

    @Provides
    @Singleton
    @WsDateFormat
    fun providesWsDateFormat(@AppLocale appLocale : Locale) : DateFormat = SimpleDateFormat("yyyy-MM-dd", appLocale)
}
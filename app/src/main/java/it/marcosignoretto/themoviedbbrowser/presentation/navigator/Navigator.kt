package it.marcosignoretto.themoviedbbrowser.presentation.navigator

import android.app.Activity
import android.content.Intent
import it.marcosignoretto.themoviedbbrowser.di.scope.ActivityScope
import it.marcosignoretto.themoviedbbrowser.presentation.model.UIMovie
import it.marcosignoretto.themoviedbbrowser.presentation.screen.detail.DetailActivity
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 19/02/2018.
 */
@ActivityScope
class Navigator @Inject constructor(
        val activity: Activity
) {


    fun navigateToMovieDetail(item: UIMovie) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.IntentKey.MOVIE_ID,item.id)
        activity.startActivity(intent)
    }

    fun navigateBack() {
        activity.finish()
    }


}
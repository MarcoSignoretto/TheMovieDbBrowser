package it.marcosignoretto.themoviedbbrowser.presentation.screen.detail

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.MenuItem
import android.view.View
import it.marcosignoretto.themoviedbbrowser.MovieApplication
import it.marcosignoretto.themoviedbbrowser.R
import it.marcosignoretto.themoviedbbrowser.di.qualifier.BasePosterPath
import it.marcosignoretto.themoviedbbrowser.di.qualifier.DetailPosterResolution
import it.marcosignoretto.themoviedbbrowser.di.qualifier.UIDateFormat
import it.marcosignoretto.themoviedbbrowser.di.subcomponent.detail.DetailActivityModule
import it.marcosignoretto.themoviedbbrowser.presentation.BaseActivity
import it.marcosignoretto.themoviedbbrowser.presentation.model.UIMovieDetail
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*
import java.text.DateFormat

import javax.inject.Inject

class DetailActivity : BaseActivity() , DetailView {

    val TAG = "DetailActivity"

    @Inject
    @field:BasePosterPath
    lateinit var basePosterPath : String

    @Inject
    @field:DetailPosterResolution
    lateinit var detailResolution : String

    @Inject
    @field:UIDateFormat
    lateinit var uiDateFormat : DateFormat

    @Inject lateinit var presenter : DetailPresenter
    var movieId : Int = -1

    object IntentKey{
        const val MOVIE_ID = "DetailActivity_IntentKey_MOVIE_ID"
    }

    object BundleKey{
        const val MOVIE_ID = "DetailActivity_BundleKey_MOVIE_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if(intent.hasExtra(IntentKey.MOVIE_ID)){
            Log.i(TAG, "id: "+intent.getIntExtra(IntentKey.MOVIE_ID,-1))
            movieId = intent.getIntExtra(IntentKey.MOVIE_ID,-1)
        }else if(savedInstanceState!= null && savedInstanceState.containsKey(BundleKey.MOVIE_ID)){
            movieId = savedInstanceState.getInt(BundleKey.MOVIE_ID)
        }

        if(movieId >= 0) {
            presenter.loadMovieWithId(movieId)
        }else{
            throw IllegalStateException("Invalid movie id")
        }


    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(BundleKey.MOVIE_ID,movieId)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        presenter.goBack()
    }

    override fun injectDependencies() {
        (application as MovieApplication).appComponent.plus(DetailActivityModule(this)).injectTo(this)
    }


    // region VIEW
    override fun startLoading() {
        progressBar.visibility = View.VISIBLE

    }

    override fun stopLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showDetail(result: UIMovieDetail) {
        supportActionBar!!.title = result.title


        contentView.title.text = result.title
        overview.text = result.overview
        result.releaseDate?.let {
            releaseDate.text = uiDateFormat.format(it)
        }

        spokenLanguages.text = result.spokenLanguages.toString()

        if(result.posterPath!=null) posterImage.setImageURI(basePosterPath+detailResolution+"/"+result.posterPath)
        else posterImage.setActualImageResource(R.drawable.ic_no_poster)

        voteAverage.text = result.voteAverage?.toString() ?: getString(R.string.na)
        voteCount.text = result.voteCount?.toString() ?: getString(R.string.na)
        popularity.text = result.popularity?.toString() ?: getString(R.string.na)
        runtime.text = result.runtime?.toString() ?: getString(R.string.na)
        revenue.text = result.revenue?.toString() ?: getString(R.string.na)
        tagline.text = if (!TextUtils.isEmpty(result.tagline)) result.tagline else getString(R.string.na)
        imdbId.text = result.imdbId ?: getString(R.string.na)
        originalLanguage.text = result.originalLanguage ?: getString(R.string.na)
        productionCompanies.text = result.productionCompanies.toString()
        productionCountries.text = result.productionCountries.toString()
        genres.text = result.genres.toString()
        if(result.adult!=null){
            adult.text = if(result.adult!!) getString(R.string.yes) else getString(R.string.no)
        }else{
            adult.text = getString(R.string.na)
        }
    }

    override fun showErrorView() {
        errorView.visibility = View.VISIBLE
        appBar.setExpanded(false)
    }

    override fun hideErrorView() {
        errorView.visibility = View.GONE
    }

    override fun showDetailView() {
        contentView.visibility = View.VISIBLE
    }

    override fun hideDetailView() {
        contentView.visibility = View.GONE
    }

    // endregion
}

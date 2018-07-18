package it.marcosignoretto.themoviedbbrowser.presentation.screen.homepage

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import it.marcosignoretto.themoviedbbrowser.MovieApplication
import it.marcosignoretto.themoviedbbrowser.R
import it.marcosignoretto.themoviedbbrowser.di.subcomponent.homepage.HomepageActivityComponent
import it.marcosignoretto.themoviedbbrowser.di.subcomponent.homepage.HomepageActivityModule
import it.marcosignoretto.themoviedbbrowser.presentation.BaseActivity
import it.marcosignoretto.themoviedbbrowser.presentation.adapter.MovieListAdapter
import it.marcosignoretto.themoviedbbrowser.presentation.model.UIMovie
import kotlinx.android.synthetic.main.activity_homepage.*
import java.util.*
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 16/02/2018.
 */

class HomepageActivity : BaseActivity(), HomepageView {

    private val TAG = "HomepageActivity"

    private lateinit var activityComponent : HomepageActivityComponent

    @Inject lateinit var presenter : HomepagePresenter
    lateinit var movieListAdapter : MovieListAdapter<HomepageActivityComponent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        setSupportActionBar(toolbar)

        movieListAdapter = MovieListAdapter(
                activityComponent,
                onClick = {
                    presenter.clickedOn(it)
                },
                onBottomReached = {
                    presenter.loadMoreData()
                }
        )
        activityComponent.injectTo(movieListAdapter)

        // Setup layout manager for recycler view
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.scrollToPosition(0)

        // Recycler
        movieRecyclerView.setHasFixedSize(true)
        movieRecyclerView.layoutManager = layoutManager
        movieRecyclerView.adapter = movieListAdapter

        presenter.loadHomepage()
    }

    override fun onResume() {
        super.onResume()
        swipeLayout.setOnRefreshListener {
            presenter.reloadMovies()
        }
        filterFab.setOnClickListener {
            presenter.showDatePicker()
        }
        resetFilterButton.setOnClickListener {
            presenter.resetFilter()
        }
    }

    override fun onPause() {
        super.onPause()
        swipeLayout.setOnRefreshListener(null)
        filterFab.setOnClickListener(null)
        resetFilterButton.setOnClickListener(null)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun injectDependencies() {
        activityComponent = (application as MovieApplication).appComponent.plus(HomepageActivityModule(this))
        activityComponent.injectTo(this)
    }













    // region VIEW
    override fun startLoading() {
        progressBar.visibility = View.VISIBLE
    }
    override fun stopLoading() {
        progressBar.visibility = View.GONE
        swipeLayout.isRefreshing = false
    }

    override fun showResults(results: List<UIMovie>) {
        movieListAdapter.items.clear()
        movieListAdapter.items.addAll(results)
        movieRecyclerView.layoutManager.scrollToPosition(0)
        movieListAdapter.notifyDataSetChanged()

    }

    override fun addResults(results: List<UIMovie>) {
        movieListAdapter.items.addAll(results)
        movieListAdapter.notifyDataSetChanged()
    }

    override fun showDatePiker() {

        val dialog = DatePickerDialog.newInstance(object : DatePickerDialog.OnDateSetListener{
            override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                val cal = Calendar.getInstance(Locale.getDefault()).clone() as Calendar
                cal.set(Calendar.HOUR_OF_DAY, 9)
                cal.set(Calendar.MINUTE, 0)
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                presenter.filterByDate(cal.time)
            }
        })
        dialog.isThemeDark = false
        dialog.show(fragmentManager!!, "DATE_PICKER_TAG")
    }

    override fun showResetFilterButton() {
        resetFilterButton.visibility = View.VISIBLE
    }

    override fun hideResetFilterButton() {
        resetFilterButton.visibility = View.GONE
    }

    override fun showEmptyView() {
        emptyList.visibility = View.VISIBLE
    }

    override fun clearResults() {
        movieListAdapter.items.clear()
        movieListAdapter.notifyDataSetChanged()
    }

    override fun showFatalErrorView() {
        errorView.visibility = View.VISIBLE
    }

    override fun hideErrorViews() {
        errorView.visibility = View.GONE
    }

    override fun showGenericError() {
        Toast.makeText(this,R.string.generic_error,Toast.LENGTH_LONG).show()
    }

    override fun hideEmptyList() {
        emptyList.visibility = View.GONE
    }

    // endregion





}
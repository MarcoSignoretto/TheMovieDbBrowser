package it.marcosignoretto.themoviedbbrowser.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import it.marcosignoretto.themoviedbbrowser.R
import it.marcosignoretto.themoviedbbrowser.di.subcomponent.ViewHolderInjectable
import it.marcosignoretto.themoviedbbrowser.presentation.model.UIMovie
import it.marcosignoretto.themoviedbbrowser.presentation.screen.homepage.MovieListItemViewHolder


/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 17/02/2018.
 */


class MovieListAdapter<T : ViewHolderInjectable<MovieListItemViewHolder>>(
        private val component: T,
        private val onClick: (UIMovie) -> Unit = {},
        private val onBottomReached: () -> Unit = {}
) : RecyclerView.Adapter<MovieListItemViewHolder>() {


    val items : MutableList<UIMovie> = ArrayList<UIMovie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent,false)
        val vh = MovieListItemViewHolder(layout)
        component.injectTo(vh)
        return vh
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MovieListItemViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            onClick(items[position])
        }

        if(position == items.size - 1)onBottomReached()
    }


}
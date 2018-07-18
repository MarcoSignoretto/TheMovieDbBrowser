package it.marcosignoretto.themoviedbbrowser.presentation.screen.homepage

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import it.marcosignoretto.themoviedbbrowser.R
import it.marcosignoretto.themoviedbbrowser.di.qualifier.BasePosterPath
import it.marcosignoretto.themoviedbbrowser.di.qualifier.ListPosterResolution
import it.marcosignoretto.themoviedbbrowser.di.qualifier.UIDateFormat
import it.marcosignoretto.themoviedbbrowser.presentation.model.UIMovie
import kotlinx.android.synthetic.main.movie_list_item.view.*
import java.text.DateFormat
import javax.inject.Inject

/**
 * Created by
 * Marco Signoretto
 * Android Developer
 * on 17/02/2018.
 */
class MovieListItemViewHolder(
        itemView: View
) : RecyclerView.ViewHolder(itemView){

    @Inject
    @field:BasePosterPath
    protected lateinit var basePosterPath : String

    @Inject
    @field:ListPosterResolution
    protected lateinit var listResolution : String

    @Inject
    @field:UIDateFormat
    protected lateinit var uiDateFormat : DateFormat


    fun bind(item: UIMovie){
        itemView.title.text = item.title

        if(!TextUtils.isEmpty(item.posterPath))itemView.posterImage.setImageURI(basePosterPath+listResolution+"/"+item.posterPath)
        else itemView.posterImage.setActualImageResource(R.drawable.ic_no_poster)

        itemView.overview.text = item.overview

        if(item.releaseDate!=null) itemView.releaseDate.text = uiDateFormat.format(item.releaseDate)
        else itemView.releaseDate.text = itemView.resources.getText(R.string.movie_list_item_na_release_date)





    }
}
package com.sf.newsapp

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.sf.NewsModel

class NewsDifCallback : DiffUtil.ItemCallback<NewsModel>() {

    override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: NewsModel, newItem: NewsModel): Any {
        val difBundle = Bundle()
        val newImagePath = newItem.imagePath
        if (newImagePath != oldItem.imagePath) {
            difBundle.putString(IMAGE_PATH, newImagePath)
        }
        val title = newItem.title
        if (title != oldItem.title) {
            difBundle.putString(NEWS_TITLE, title)
        }
        val favoriteState = newItem.isFavorite
        if (favoriteState != oldItem.isFavorite) {
            difBundle.putBoolean(FAVORITE_STATE, favoriteState)
        }
        return difBundle
    }

    companion object {
        internal const val IMAGE_PATH = "image_path"
        internal const val NEWS_TITLE = "news_title"
        internal const val FAVORITE_STATE = "favorite_state"
    }
}
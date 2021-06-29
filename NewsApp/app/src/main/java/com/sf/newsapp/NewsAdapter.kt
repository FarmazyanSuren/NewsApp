package com.sf.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sf.NewsModel

class NewsAdapter(
    private val onFavoriteCallback: OnRecyclerItemClick
) : ListAdapter<NewsModel, NewsAdapter.NewsHolder>(NewsDifCallback()) {

    private val imagePathKey = NewsDifCallback.IMAGE_PATH
    private val titleKey = NewsDifCallback.NEWS_TITLE
    private val favoriteKey = NewsDifCallback.FAVORITE_STATE

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsHolder(view, onFavoriteCallback)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(currentList[holder.adapterPosition])
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
            return
        }
        val bundle = payloads[0] as? Bundle ?: return
        with(bundle) {
            if (containsKey(imagePathKey)) {
                holder.updateImage(bundle.getString(imagePathKey))
            }
            if (containsKey(titleKey)) {
                holder.updateTitle(bundle.getString(titleKey))
            }
            if (containsKey(favoriteKey)) {
                holder.updateButtonState(bundle.getBoolean(favoriteKey))
            }
        }
    }

    class NewsHolder(
        itemView: View, onFavoriteCallback: OnRecyclerItemClick
    ) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.newsImage)
        private val titleView: TextView = itemView.findViewById(R.id.newsTitle)
        private val favoriteButton: ImageView = itemView.findViewById(R.id.favoriteBtn)

        init {
            favoriteButton.setOnClickListener {
                onFavoriteCallback.invoke(adapterPosition)
            }
        }

        fun bind(newsItem: NewsModel) {
            updateImage(newsItem.imagePath)
            updateTitle(newsItem.title)
            updateButtonState(newsItem.isFavorite)
        }

        fun updateImage(imagePath: String?) {
            imageView.load(imagePath)
        }

        fun updateTitle(title: String?) {
            titleView.text = title
        }

        fun updateButtonState(isSelected: Boolean) {
            favoriteButton.isSelected = isSelected
        }

    }
}

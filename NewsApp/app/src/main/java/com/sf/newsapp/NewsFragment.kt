package com.sf.newsapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : Fragment(R.layout.fragment_news) {

    private var newsAdapter: NewsAdapter? = null
    private val newsViewModel: NewsViewModel by viewModel()

    private val onFavoriteCallback: OnRecyclerItemClick = { pos ->
        newsViewModel.updateFavoriteItem(pos)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsViewModel.newsList.observe(viewLifecycleOwner) {
            newsAdapter?.submitList(it)
        }

        view.findViewById<RecyclerView>(R.id.newsRecycler)?.apply {
            newsAdapter = NewsAdapter(onFavoriteCallback)
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewsFragment()
    }
}

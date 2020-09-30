package id.kotlin.mvvm.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import dagger.android.support.DaggerAppCompatActivity
import id.kotlin.mvvm.R
import id.kotlin.mvvm.domain.HomeEntity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject


class HomeActivity : DaggerAppCompatActivity(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter

    private var adapter: HomeAdapter? = null
    private var isLoading: Boolean = false
    private var currentPage: Long = -1L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter.discoverMovie()
        navigationHandler()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    override fun onShowLoading() {
        pb_home.visibility = View.VISIBLE
    }

    override fun onHideLoading() {
        pb_home.visibility = View.GONE
        rv_movies.visibility = View.VISIBLE
    }

    override fun onSuccess(entity: HomeEntity) {
        adapter = HomeAdapter(entity.results.toMutableList())
        rv_movies.addItemDecoration(
            DividerItemDecoration(
                this@HomeActivity,
                DividerItemDecoration.VERTICAL
            )
        )
        rv_movies.adapter = adapter

        currentPage = entity.page
        rv_movies.addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (currentPage >= entity.totalPages || isLoading) return

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount

                if (visibleItemCount.plus(firstVisibleItemPosition) >= totalItemCount) {
                    adapter?.showLoading()
                    isLoading = true
                    currentPage++
                    presenter.loadMore(currentPage)
                }
            }
        })
    }

    override fun onError(error: Throwable) {
        Toast.makeText(
            this@HomeActivity,
            "${error.printStackTrace()}",
            Toast.LENGTH_SHORT
        )
    }

    override fun onPaginationSuccess(entity: HomeEntity) {
        currentPage = entity.page
        hideLoading()
        adapter?.loadMore(entity.results.toMutableList())
    }

    override fun onPaginationError(error: Throwable) {
        Toast.makeText(
            this@HomeActivity,
            "${error.printStackTrace()}",
            Toast.LENGTH_SHORT
        )

        currentPage--
        hideLoading()
    }

    private fun hideLoading() {
        adapter?.hideLoading()
        isLoading = false
    }

    private fun navigationHandler() {
        bn_home.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {

                }
                R.id.navigation_help -> {

                }
                R.id.navigation_profile -> {

                }
                R.id.navigation_search -> {

                }
            }
            true
        }
    }
}
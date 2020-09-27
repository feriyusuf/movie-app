package id.kotlin.mvvm.data

import id.kotlin.mvvm.BuildConfig
import io.reactivex.Single

class HomeFactory(private val dataSource: HomeDataSource) {
    fun discoverMovie(page: Long): Single<HomeResponse> =
        dataSource.discoverMovie(
            apiKey = BuildConfig.API_KEY,
            page = page
        )
}
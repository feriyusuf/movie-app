package id.kotlin.mvvm.data

import id.kotlin.mvvm.BuildConfig
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDataSource {
    @GET("/3/discover/movie")
    fun discoverMovie(
        @Query("api_key")
        apiKey: String,

        @Query(value = "page")
        page: Long
    ): Single<HomeResponse>
}
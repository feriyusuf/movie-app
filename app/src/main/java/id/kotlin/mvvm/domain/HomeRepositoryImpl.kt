package id.kotlin.mvvm.domain

import id.kotlin.mvvm.data.HomeFactory
import io.reactivex.Single
import id.kotlin.mvvm.domain.HomeEntity.Result

/**
 * Digunakan untuk memudahkan kita melakukan testing
 * pada unit terkecil dari domain layer kita dikemudian hari
 */
class HomeRepositoryImpl(
    private val factory: HomeFactory
) : HomeRepository {
    override fun discoverMovie(param: HomeParam): Single<HomeEntity> =
        factory.discoverMovie(param.page).map { response ->
            HomeEntity(
                page = response.page ?: -1L,
                totalPages = response.totalPages ?: -1L,
                results = response.results?.map { result ->
                    Result(
                        title = result.title ?: "Untitled",
                        overview = result.overview ?: "No Description"
                    )
                }?.toMutableList() ?: mutableListOf()
            )
        }
}
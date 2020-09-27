package id.kotlin.mvvm.domain

import io.reactivex.Single

/**
 * Digunakan untuk mengubah pertukaran atau transofrmasi data dari
 * data layer ke domain layer
 **/
interface HomeRepository {

    fun discoverMovie(param: HomeParam): Single<HomeEntity>
}
package id.kotlin.mvvm.presentation

import id.kotlin.mvvm.domain.HomeEntity

interface HomeView {

    fun onShowLoading()
    fun onHideLoading()

    fun onSuccess(entity: HomeEntity)
    fun onError(error: Throwable)

    fun onPaginationSuccess(entity: HomeEntity)
    fun onPaginationError(error: Throwable)
}
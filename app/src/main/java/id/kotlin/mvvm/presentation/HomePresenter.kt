package id.kotlin.mvvm.presentation

import id.kotlin.mvvm.domain.HomeEntity
import id.kotlin.mvvm.domain.HomeParam
import id.kotlin.mvvm.domain.HomeUsecase
import id.kotlin.mvvm.domain.common.DefaultObserver

class HomePresenter(
    private val view: HomeView,
    private val usecase: HomeUsecase
) {

    fun discoverMovie() {
        view.onShowLoading()
        usecase.execute(
            DiscoverMovieUsecase(),
            HomeParam()
        )
    }

    fun loadMore(page: Long) {
        usecase.execute(
            LoadMoreUsecase(),
            HomeParam(page = page)
        )
    }

    fun onDetach() {
        usecase.dispose()
    }

    inner class DiscoverMovieUsecase : DefaultObserver<HomeEntity> () {
        override fun onSuccess(entity: HomeEntity) {
            view.onHideLoading()
            view.onSuccess(entity)
        }

        override fun onError(exception: Throwable) {
            view.onHideLoading()
            view.onError(exception)
        }
    }

    inner class LoadMoreUsecase: DefaultObserver<HomeEntity>() {
        override fun onSuccess(entity: HomeEntity) {
            view.onPaginationSuccess(entity)
        }

        override fun onError(exception: Throwable) {
            view.onPaginationError(exception)
        }
    }
}
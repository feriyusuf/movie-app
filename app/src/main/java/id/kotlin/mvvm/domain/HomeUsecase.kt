package id.kotlin.mvvm.domain

import id.kotlin.mvvm.domain.common.Usecase
import id.kotlin.mvvm.domain.executor.JobExecutor
import id.kotlin.mvvm.domain.executor.UIThread
import io.reactivex.Single

/**
 * Bertujuan untuk melakukan eksekusi atau menjalankan perintah
 * dari domain layer ke data layer
 */
class HomeUsecase(
    private val repository: HomeRepository,
    executor: JobExecutor,
    thread: UIThread
) : Usecase<HomeEntity, HomeParam>(executor, thread) {
    override fun buildUsecaseObservable(params: HomeParam): Single<HomeEntity> =
        repository.discoverMovie(params)
}
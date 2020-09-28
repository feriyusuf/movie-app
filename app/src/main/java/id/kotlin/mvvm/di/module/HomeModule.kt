package id.kotlin.mvvm.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import id.kotlin.mvvm.data.HomeDataSource
import id.kotlin.mvvm.data.HomeFactory
import id.kotlin.mvvm.di.scope.Presentation
import id.kotlin.mvvm.domain.HomeRepository
import id.kotlin.mvvm.domain.HomeRepositoryImpl
import id.kotlin.mvvm.domain.HomeUsecase
import id.kotlin.mvvm.domain.executor.JobExecutor
import id.kotlin.mvvm.domain.executor.UIThread
import id.kotlin.mvvm.presentation.HomeActivity
import id.kotlin.mvvm.presentation.HomePresenter
import id.kotlin.mvvm.presentation.HomeView
import retrofit2.Retrofit

@Module
abstract class HomeModule {

    @Module
    companion object {

        @JvmStatic
        @Presentation
        @Provides
        fun providesDataSource(retrofit: Retrofit): HomeDataSource =
            retrofit.create(HomeDataSource::class.java)

        @JvmStatic
        @Presentation
        @Provides
        fun providesFactory(dataSource: HomeDataSource): HomeFactory =
            HomeFactory(dataSource)

        @JvmStatic
        @Presentation
        @Provides
        fun providesRepository(factory: HomeFactory): HomeRepositoryImpl =
            HomeRepositoryImpl(factory)

        @JvmStatic
        @Presentation
        @Provides
        fun providesUsecase(
            repository: HomeRepository,
            executor: JobExecutor,
            thread: UIThread
        ): HomeUsecase = HomeUsecase(repository, executor, thread)

        @JvmStatic
        @Presentation
        @Provides
        fun providesPresenter(
            view: HomeView,
            usecase: HomeUsecase
        ): HomePresenter = HomePresenter(view, usecase)
    }


    @Binds
    abstract fun bindRepository(repositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    abstract fun bindView(activity: HomeActivity): HomeView
}
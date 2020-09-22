package id.kotlin.mvvm.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import id.kotlin.mvvm.data.HomeDataSource
import id.kotlin.mvvm.di.scope.ViewModelKey
import id.kotlin.mvvm.presentation.HomeActivity
import id.kotlin.mvvm.presentation.HomeViewModel
import retrofit2.Retrofit

@Module
abstract class HomeModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesHomeDataSource(retrofit: Retrofit): HomeDataSource =
            retrofit.create(HomeDataSource::class.java)
    }

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModelCallback(activity: HomeActivity): ViewModel
}
package id.kotlin.mvvm.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.kotlin.mvvm.MvvmMovieApp
import id.kotlin.mvvm.di.builder.ActivityBuilder
import id.kotlin.mvvm.di.module.ApplicationModule
import id.kotlin.mvvm.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        NetworkModule::class,
        ActivityBuilder::class
    ]
)
interface ApplicationComponent : AndroidInjector<MvvmMovieApp>

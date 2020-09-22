package id.kotlin.mvvm.di.bulider

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.mvvm.di.factory.ViewModelFactory
import id.kotlin.mvvm.di.module.HomeModule
import id.kotlin.mvvm.di.scope.Presentation
import id.kotlin.mvvm.presentation.HomeActivity

@Module
abstract class ActivityBuilder {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}
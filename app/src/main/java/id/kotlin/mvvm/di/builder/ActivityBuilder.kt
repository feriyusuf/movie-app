package id.kotlin.mvvm.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.mvvm.di.module.HomeModule
import id.kotlin.mvvm.di.scope.Presentation
import id.kotlin.mvvm.presentation.HomeActivity

@Module
abstract class ActivityBuilder {

    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}
package id.kotlin.mvvm

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import id.kotlin.mvvm.di.component.DaggerApplicationComponent


class MvvmMovieApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.create().apply { inject(this@MvvmMovieApp) }
    }

}
package id.kotlin.mvvm.di.module

import dagger.Module
import dagger.Provides
import id.kotlin.mvvm.domain.executor.JobExecutor
import id.kotlin.mvvm.domain.executor.UIThread
import javax.inject.Singleton

@Module
internal class ApplicationModule {
    @Provides
    @Singleton
    fun providesJobExecutor(): JobExecutor = JobExecutor()

    @Provides
    @Singleton
    fun providesUIThread(): UIThread = UIThread()
}
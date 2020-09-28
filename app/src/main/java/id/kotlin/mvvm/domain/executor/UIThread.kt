package id.kotlin.mvvm.domain.executor

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

interface PostExecutionThread {
    val scheduler: Scheduler
}

class UIThread : PostExecutionThread {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}
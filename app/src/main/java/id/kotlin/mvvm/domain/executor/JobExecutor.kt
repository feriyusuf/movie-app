package id.kotlin.mvvm.domain.executor

import java.util.concurrent.*

interface ThreadExecutor : Executor

class JobExecutor : ThreadExecutor {

    private val threadPoolExecutor = ThreadPoolExecutor(
        3,
        5,
        10,
        TimeUnit.SECONDS,
        LinkedBlockingQueue(),

        )

    override fun execute(command: Runnable?) {
        command?.let { }
    }
}

class JobThreadFactory(private var counter: Int = 0) : ThreadFactory {
    override fun newThread(runnable: Runnable?) =
        Thread(runnable, "android_${counter.inc()}")
}
package id.kotlin.mvvm

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class HomeObserver: LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun connect() {
        Log.d(HomeObserver::class.java.simpleName, "Connect")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun disconnect() {
        Log.e(HomeObserver::class.java.simpleName, "Disconnect")
    }
}
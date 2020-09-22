package id.kotlin.mvvm.presentation

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.kotlin.mvvm.data.HomeDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val dataSource: HomeDataSource
) : ViewModel(), HomeView {


    private val disposables = CompositeDisposable()
    private val observer = MutableLiveData<HomeViewState>()

    override val states: LiveData<HomeViewState>
        get() = observer


    override fun discoverMovie() {
        // Reactive programming
        dataSource.discoverMovie()
            .map<HomeViewState>(HomeViewState::Success)
            .onErrorReturn(HomeViewState::Error)
            .toFlowable()
            .startWith(HomeViewState.Loading)
            .subscribe(observer::postValue)
            .let(disposables::add)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}
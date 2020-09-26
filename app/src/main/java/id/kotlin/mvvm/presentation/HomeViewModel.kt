package id.kotlin.mvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.kotlin.mvvm.data.HomeDataSource
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val dataSource: HomeDataSource
) : ViewModel(), HomeView {


    private val disposables = CompositeDisposable()
    private val observer = MutableLiveData<HomeViewState>()

    override val states: LiveData<HomeViewState>
        get() = observer

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

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

}
package id.kotlin.mvvm.presentation

import id.kotlin.mvvm.data.HomeResponse

sealed class HomeViewState {

    object Loading : HomeViewState()

    data class Success(val response: HomeResponse) : HomeViewState()
    data class Error(val error: Throwable) : HomeViewState()
}
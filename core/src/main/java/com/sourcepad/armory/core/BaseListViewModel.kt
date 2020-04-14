package com.sourcepad.armory.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseListViewModel : ViewModel() {

    protected val loadingState = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> = loadingState

    protected val onError = MutableLiveData<Exception>()
    val errorLiveData: LiveData<Exception> = onError

    protected open val onSuccess = MutableLiveData<Unit>()
    open val successLiveData: LiveData<Unit> = onSuccess

}
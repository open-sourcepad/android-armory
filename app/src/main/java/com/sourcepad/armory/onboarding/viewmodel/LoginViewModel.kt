package com.sourcepad.armory.onboarding.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sourcepad.armory.core.Resource
import com.sourcepad.armory.core.template.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel @ViewModelInject constructor(private val accountRepository: AccountRepository) : ViewModel() {


    private val internalResource = MutableLiveData<Resource<Unit>>()
    val resourceLiveData: LiveData<Resource<Unit>> = internalResource

    fun login(email: String, password: String) = viewModelScope.launch() {
        accountRepository.login(email, password).collect {

            when (it) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                }
                is Resource.Error -> {
                }
            }

            withContext(Dispatchers.Main) {
                internalResource.value = it
            }
        }
    }


}
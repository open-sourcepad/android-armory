package com.sourcepad.armory.core.template

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sourcepad.armory.core.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AccountViewModel : ViewModel() {

    private lateinit var accountRepository: AccountRepository

    private val internalLoginEvent = MutableLiveData<Resource<Unit>>()
    val loginEvent: LiveData<Resource<Unit>> = internalLoginEvent

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
                internalLoginEvent.value = it
            }
        }
    }


}
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
        //TODO add map if converting to UiModel, remove if not transformation/action needed per Resource
        accountRepository.login(email, password).onEach {
            when (it) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                }
                is Resource.Error -> {
                }
            }
        }.collect {
            withContext(Dispatchers.Main) {
                internalLoginEvent.value = it
            }
        }
    }


}
package com.sourcepad.armory

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.sourcepad.armory.core.template.AccountRepository


class MainViewModel @ViewModelInject constructor( val repository: AccountRepository) :
    ViewModel() {
}
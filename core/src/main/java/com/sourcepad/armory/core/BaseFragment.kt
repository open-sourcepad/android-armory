package com.sourcepad.armory.core

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchObservers()
        getData()
    }


    protected abstract fun launchObservers()

    protected abstract fun getData()

}
package com.sourcepad.armory.core

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment(resLayoutId: Int) : Fragment(resLayoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findViews(view)
        launchObservers()
    }

    protected abstract fun findViews(view: View)


    protected abstract fun launchObservers()

}
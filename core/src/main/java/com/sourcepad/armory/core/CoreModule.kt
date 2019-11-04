package com.sourcepad.armory.core

import com.sourcepad.armory.db.dbModule
import com.sourcepad.armory.webservice.webServiceModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val coreModule = module {
    loadKoinModules(arrayListOf(webServiceModule, dbModule))
}

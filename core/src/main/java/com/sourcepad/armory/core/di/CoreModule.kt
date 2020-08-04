package com.sourcepad.armory.core.di

import com.sourcepad.armory.core.template.AccountRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class CoreModule {


    @Provides
    @Singleton
    fun provideAccountRepository(): AccountRepository {
        return AccountRepository()
    }
}
package com.sourcepad.armory.core.di

import com.sourcepad.armory.core.repository.AccountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoreModule {


    @Provides
    @Singleton
    fun provideAccountRepository(): AccountRepository {
        return AccountRepository()
    }
}
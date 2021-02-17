package com.example.android.hilt.di

import com.example.android.hilt.data.LoggerDataSource
import com.example.android.hilt.data.LoggerInMemoryDataSource
import com.example.android.hilt.data.LoggerLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class InMemoryLogger

@Qualifier
annotation class DatabaseLogger


@InstallIn(ApplicationComponent::class)
@Module
abstract class LoggingDatabaseModule{

    @DatabaseLogger
    @Singleton
    @Binds
    abstract fun bindDatabaseLogger(impl: LoggerLocalDataSource): LoggerDataSource
}


@InstallIn(ApplicationComponent::class)
@Module
abstract class LogginInMemoryModule{

    @InMemoryLogger
    @ActivityScoped
    @Binds
    abstract fun bindD(impl: LoggerInMemoryDataSource): LoggerDataSource
}



package com.android.aop.part2.navermovieapi.di

import com.android.aop.part2.navermovieapi.data.repo.NaverRepository
import com.android.aop.part2.navermovieapi.data.repo.NaverRepositoryImpl
import com.android.aop.part2.navermovieapi.data.resource.NaverRemoteDataSource
import com.android.aop.part2.navermovieapi.data.resource.NaverRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindNaverRepository(
        naverRepositoryImpl: NaverRepositoryImpl
    ): NaverRepository

    @Singleton
    @Binds
    abstract fun bindNaverRemoteDataSource(
        naverRemoteDataSourceImpl: NaverRemoteDataSourceImpl
    ): NaverRemoteDataSource
}
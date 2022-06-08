package com.android.aop.part2.navermovieapi.data.repo

import com.android.aop.part2.navermovieapi.api.NaverMovieResponse
import com.android.aop.part2.navermovieapi.data.resource.NaverRemoteDataSource
import javax.inject.Inject

class NaverRepositoryImpl @Inject constructor(private val naverRemoteDataSource: NaverRemoteDataSource):NaverRepository{
    override fun search(
        query: String,
        onSuccess: (NaverMovieResponse) -> Unit,
        onFailure: (String) -> Unit
    ) {
        naverRemoteDataSource.search(query,onSuccess,onFailure)
    }

}
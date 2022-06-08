package com.android.aop.part2.navermovieapi.data.resource

import com.android.aop.part2.navermovieapi.api.NaverMovieResponse

interface NaverRemoteDataSource {

    fun search(query: String, onSuccess: (NaverMovieResponse) -> Unit, onFailure: (String) -> Unit)
}
package com.android.aop.part2.navermovieapi.data.repo

import com.android.aop.part2.navermovieapi.api.NaverMovieResponse

interface NaverRepository {

    fun search(query: String, onSuccess: (NaverMovieResponse) -> Unit, onFailure: (String) -> Unit)
}
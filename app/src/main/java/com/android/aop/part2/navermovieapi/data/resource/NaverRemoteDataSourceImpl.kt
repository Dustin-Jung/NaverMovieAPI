package com.android.aop.part2.navermovieapi.data.resource

import com.android.aop.part2.navermovieapi.api.NaverMovieResponse
import com.android.aop.part2.navermovieapi.api.NaverService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class NaverRemoteDataSourceImpl @Inject constructor( private val naverService: NaverService) : NaverRemoteDataSource{
    override fun search(
        query: String,
        onSuccess: (NaverMovieResponse) -> Unit,
        onFailure: (String) -> Unit
    ) {
        naverService.search(query = query).enqueue(object: Callback<NaverMovieResponse>{
            override fun onResponse(
                call: Call<NaverMovieResponse>,
                response: Response<NaverMovieResponse>
            ) {
               response.body()?.let(onSuccess)
            }

            override fun onFailure(call: Call<NaverMovieResponse>, t: Throwable) {
                onFailure.invoke(t.message?: "error")
            }

        })
    }
}
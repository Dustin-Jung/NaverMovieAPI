package com.android.aop.part2.navermovieapi.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverService {

    companion object{
        private const val NAVER_CLIENT_ID = "LMGisimDg508NH31NQz5"
        private const val NAVER_SECRET_ID = "xtEVOk0SV1"

    }

    @GET("v1/search/movie")
    fun search(
        @Header("X-Naver-Client-Id") id: String = NAVER_CLIENT_ID,
        @Header("X-Naver-Client-Secret") secret: String = NAVER_SECRET_ID,
        @Query("query") query : String
    ): Call<NaverMovieResponse>
}
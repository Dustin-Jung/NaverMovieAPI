package com.android.aop.part2.navermovieapi.api

data class NaverMovieResponse(
    val display: Int,
    val items: List<Item>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)
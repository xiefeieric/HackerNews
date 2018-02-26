package me.feixie.hackernews.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface HackerStoryService {
    @GET("{story}")
    fun getHackerStory(@Path("story") story: String): Observable<List<Int>>
}

interface HackerItemService {
    @GET("item/{item}")
    fun getHackerItem(@Path("item") item: String): Observable<ModelItem>
}
package me.feixie.hackernews.api

import io.reactivex.Observable
import me.feixie.hackernews.HackerApplication
import timber.log.Timber

object Service {

    fun getStory(story:String): Observable<List<Int>> {
        Timber.d(story)
        val storyService = HackerApplication.mRetrofit.create(HackerStoryService::class.java)
        return storyService.getHackerStory(story)
    }

    fun getItem(item:Int): Observable<ModelItem> {
        val itemService = HackerApplication.mRetrofit.create(HackerItemService::class.java)
        return itemService.getHackerItem(item.toString())
    }
}
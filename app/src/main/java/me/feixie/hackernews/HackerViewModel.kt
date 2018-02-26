package me.feixie.hackernews

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.feixie.hackernews.dagger2.ApiServiceModule
import me.feixie.hackernews.dagger2.DaggerServiceComponent
import timber.log.Timber

class HackerViewModel:ViewModel() {

    private val mDisposable = CompositeDisposable()
    private val mService = DaggerServiceComponent.builder()
            .apiServiceModule(ApiServiceModule())
            .build()
            .injectService()
    private val mLiveStories:MutableLiveData<List<Int>> = MutableLiveData()

    fun getLiveStories(story:String): MutableLiveData<List<Int>> {
        mDisposable.add(
                mService.getStory(story)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ items ->
                            mLiveStories.value = items
                        }, {
                            error -> Timber.d(error.printStackTrace().toString())
                        })
        )
        return mLiveStories
    }

    override fun onCleared() {
        super.onCleared()
        mDisposable.clear()
    }
}
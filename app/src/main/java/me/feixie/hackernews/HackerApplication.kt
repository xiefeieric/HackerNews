package me.feixie.hackernews

import android.app.Application
import com.squareup.leakcanary.LeakCanary
import me.feixie.hackernews.dagger2.AppComponent
import me.feixie.hackernews.dagger2.AppModule
import me.feixie.hackernews.dagger2.DaggerAppComponent
import net.danlew.android.joda.JodaTimeAndroid
import retrofit2.Retrofit
import timber.log.Timber

class HackerApplication: Application() {

    private lateinit var mComponent:AppComponent

    companion object {
        lateinit var instance:HackerApplication
        lateinit var mRetrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        JodaTimeAndroid.init(this)
        mComponent = DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()
        mRetrofit = mComponent.injectRetrofit()

        //development only features
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())

            if (LeakCanary.isInAnalyzerProcess(this)) {
                // This process is dedicated to LeakCanary for heap analysis.
                // You should not init your app in this process.
                return;
            }
            LeakCanary.install(this);
        }
    }
}
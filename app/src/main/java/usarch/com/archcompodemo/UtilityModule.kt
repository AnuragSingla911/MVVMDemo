package usarch.com.archcompodemo

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class UtilityModule {


    @Provides
    fun getRepo(webService: WebService?) : Repo {
        return Repo(webService);
    }

    @Provides
    @Named("android")
    fun getMainThreadScheduler() : Scheduler {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Named("io")
    fun getBackgroundThreadSchedulers() : Scheduler {
        return Schedulers.io();
    }



    @Provides
    fun getWebService(retrofit: Retrofit?) : WebService? {
        return retrofit?.create(WebService :: class.java);
    }

    @Provides
    @Singleton
    fun getRetrofit(gsonConverterFactory: GsonConverterFactory, callAdapterFactory: RxJavaCallAdapterFactory) : Retrofit? {
        return Retrofit.Builder().baseUrl("https://api.myjson.com/bins/").addCallAdapterFactory(callAdapterFactory).
                addConverterFactory(gsonConverterFactory).build();
    }

    @Provides
    fun getGsonFactory() : GsonConverterFactory{
        return GsonConverterFactory.create();
    }

    @Provides
    fun getCallAdapterFactory() : RxJavaCallAdapterFactory{
        return RxJavaCallAdapterFactory.create();
    }


}
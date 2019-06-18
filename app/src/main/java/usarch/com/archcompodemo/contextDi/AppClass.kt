package usarch.com.archcompodemo.contextDi

import android.app.Activity
import android.app.Application
import android.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject


class AppClass : Application() , HasActivityInjector{


    override fun onCreate() {
        super.onCreate()
        DaggerAppCompo.builder().application(this).build().inject(this);
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>;

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector;
    }

}
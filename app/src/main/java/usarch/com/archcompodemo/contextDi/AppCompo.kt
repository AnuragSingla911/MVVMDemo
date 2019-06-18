package usarch.com.archcompodemo.contextDi

import android.app.Application
import dagger.Component
import dagger.BindsInstance
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidInjectionModule::class, AppModule::class, MainActivityModule::class))
interface AppCompo {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder

        fun build(): AppCompo
    }

    fun inject(app: AppClass)
}
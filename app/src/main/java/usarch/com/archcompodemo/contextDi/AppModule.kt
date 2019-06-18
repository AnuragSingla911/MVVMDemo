package usarch.com.archcompodemo.contextDi

import android.app.Application
import android.content.Context
import dagger.Component
import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import usarch.com.archcompodemo.UtilityModule
import usarch.com.archcompodemo.ViewModelFactory


@Module(subcomponents = arrayOf(ViewModelSubComponent::class), includes = arrayOf(UtilityModule::class))
class AppModule {

    @Singleton
    @Provides
    fun provideViewModelFactory(builder: ViewModelSubComponent.Builder): ViewModelFactory {
        return ViewModelFactory(builder.build());
    }

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }
}
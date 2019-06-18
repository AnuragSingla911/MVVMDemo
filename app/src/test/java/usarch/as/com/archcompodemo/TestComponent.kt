package usarch.`as`.com.archcompodemo

import android.content.Context
import dagger.Component
import usarch.com.archcompodemo.RepoComponent
import usarch.com.archcompodemo.ViewModelFactory
import usarch.com.archcompodemo.contextDi.AppModule

@Component(modules = arrayOf(AppModule::class))
interface TestComponent{

    fun getFactory() : ViewModelFactory


}
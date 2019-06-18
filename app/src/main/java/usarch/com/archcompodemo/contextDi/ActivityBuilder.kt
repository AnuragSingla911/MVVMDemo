package usarch.com.archcompodemo.contextDi

import dagger.Module
import dagger.android.ContributesAndroidInjector
import usarch.com.archcompodemo.MainActivity


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    internal abstract fun bindMainActivity(): MainActivity

}
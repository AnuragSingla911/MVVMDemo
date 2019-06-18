package usarch.com.archcompodemo.contextDi

import dagger.Module
import dagger.android.ContributesAndroidInjector
import usarch.com.archcompodemo.MainActivity


@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    internal abstract fun contributeMainActivity(): MainActivity




}
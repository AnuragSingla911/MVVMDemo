package usarch.com.archcompodemo.contextDi

import dagger.Module
import dagger.android.ContributesAndroidInjector
import usarch.com.archcompodemo.ListFragment

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListFragment
}

package usarch.com.archcompodemo.contextDi

import dagger.Subcomponent
import usarch.com.archcompodemo.PostViewModel


@Subcomponent
interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

    fun postViewModel(): PostViewModel
}
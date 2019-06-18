package usarch.com.archcompodemo

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import usarch.com.archcompodemo.contextDi.ViewModelSubComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFactory : ViewModelProvider.Factory {

    var repo : Repo;
    var viewModelSubComponent: ViewModelSubComponent;

    @Inject
    constructor(viewModelSubComponent: ViewModelSubComponent){
        this.viewModelSubComponent = viewModelSubComponent;
        repo = DaggerRepoComponent.builder().build().getRepo();
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return viewModelSubComponent.postViewModel() as T;
    }

}
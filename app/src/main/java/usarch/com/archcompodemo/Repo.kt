package usarch.com.archcompodemo

import android.arch.lifecycle.MutableLiveData
import rx.Observable
import javax.inject.Inject

open class Repo {

    @Inject
    constructor(webService: WebService?){
        this.webService = webService;
    }


    var webService : WebService?

    open fun getDate() : Observable<List<String>>?{
        return webService?.getData();
    }

    open fun test(){

    }
}
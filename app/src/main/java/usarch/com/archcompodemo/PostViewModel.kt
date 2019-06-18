package usarch.com.archcompodemo

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.util.Log
import rx.Scheduler
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named


open class PostViewModel constructor() : ViewModel() {

    @Inject
    constructor(repo: Repo) : this(){
        this.repo = repo;
    }


    override fun onCleared() {
        super.onCleared()
            disposable?.unsubscribe();

    }



    var progressVisibility : ObservableBoolean = ObservableBoolean(true);

    var data : MutableLiveData<ArrayList<String>> = MutableLiveData();

    open var disposable : Subscription? = null

    open lateinit var repo : Repo;



    fun fetchData() {

        disposable = repo.getDate()?.
                observeOn(AndroidSchedulers.mainThread())?.
                subscribeOn(Schedulers.io())?.
                subscribe({
                    data ->
                    repo.test()
                    this.progressVisibility.set(false)
                    this.data.value = ArrayList(data)

                }, {
                    error -> Log.d("error"," error.. "+ error.message);
                })

    }
}
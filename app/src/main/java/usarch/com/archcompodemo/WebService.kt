package usarch.com.archcompodemo

import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.http.GET
import rx.Observable
import java.util.*


interface WebService {

    @GET("mza7i")
    fun getData(): Observable<List<String>>
}
package usarch.`as`.com.archcompodemo

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import rx.Scheduler
import rx.android.plugins.RxAndroidSchedulersHook
import usarch.com.archcompodemo.PostViewModel
import usarch.com.archcompodemo.Repo
import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.rules.TestRule
import org.junit.Rule




open class PostViewModelTest {

    @Mock
    lateinit var repo : Repo

    lateinit var viewModel: PostViewModel

    @get:Rule
     var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup(){


        MockitoAnnotations.initMocks(this);

        rx.android.plugins.RxAndroidPlugins.getInstance().reset();
        rx.android.plugins.RxAndroidPlugins.getInstance().registerSchedulersHook(androidRxHook)
    }

    @Test
    fun test(){
        viewModel = PostViewModel(repo)
        val c = arrayListOf<String>("er","er")
        var observable : rx.Observable<List<String>> = rx.Observable.just(c);

        Mockito.`when`(repo.getDate()).thenReturn(observable);

        viewModel.fetchData();


        Mockito.verify(repo).getDate();
        Mockito.verify(repo).test();



        Assert.assertEquals(false, viewModel.progressVisibility.get())




    }

    @After
    fun after(){
        rx.android.plugins.RxAndroidPlugins.getInstance().reset();
    }


    private val androidRxHook = object : RxAndroidSchedulersHook() {


        override fun getMainThreadScheduler(): Scheduler {
            return rx.schedulers.Schedulers.immediate()
        }
    }


}
package usarch.com.archcompodemo.contextDi

import android.support.v4.app.Fragment
import dagger.Module

@Module
class fragmentmodule {

    lateinit var fragment : Fragment;

    constructor(fragment: Fragment){
        this.fragment = fragment;
    }





}
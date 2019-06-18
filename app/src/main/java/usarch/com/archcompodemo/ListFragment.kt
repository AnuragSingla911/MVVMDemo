package usarch.com.archcompodemo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import usarch.com.archcompodemo.databinding.ListFragmentBinding
import javax.inject.Inject

class ListFragment : Fragment() , View.OnClickListener {

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context)
    }


    override fun onClick(p0: View?) {
        onTouch(p0);
    }

    lateinit var model : PostViewModel;
    lateinit var fragmentBinding: ListFragmentBinding;

    @Inject
    lateinit var viewModelFactory: ViewModelFactory;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        fragmentBinding = DataBindingUtil.inflate<ListFragmentBinding>(inflater, R.layout.list_fragment, container, false);
        fragmentBinding.postList.layoutManager = LinearLayoutManager(this.context);

        model = ViewModelProviders.of(requireActivity(), viewModelFactory).get(PostViewModel :: class.java);

        model.data.observe(this, Observer<ArrayList<String>> {
            data ->
            var adapter : ArrayAdapter<String> = ArrayAdapter<String>(this.requireContext(), data);


        fragmentBinding.postList.adapter = adapter;
        });

        fragmentBinding.viewModel = model;
        return fragmentBinding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBinding.btn.setOnClickListener {
            view -> onTouch(view);
        };
    }

    fun onTouch(view : View?){
        model.fetchData();
    }
}
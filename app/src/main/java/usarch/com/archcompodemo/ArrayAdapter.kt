package usarch.com.archcompodemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ArrayAdapter<T> constructor() : RecyclerView.Adapter<ArrayAdapter.ViewHolder>() {

    var mList : ArrayList<T>? = ArrayList();
    lateinit var context : Context;

    constructor(context: Context,data: ArrayList<T>?) : this() {
        mList = data;
        this.context = context;
    }

    override fun getItemCount(): Int {
        return mList?.size!!
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.textView.setText(mList?.get(p1).toString());
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var inflater : LayoutInflater = LayoutInflater.from(context);

        var view : View = inflater.inflate(android.R.layout.simple_list_item_1, p0, false);

        var holder : ViewHolder = ViewHolder(view);

        return holder;
    }

    class ViewHolder : RecyclerView.ViewHolder {
        lateinit var textView : TextView;

        constructor(_data: View) : super(_data) {

            textView = _data as TextView;

        }
    }
}
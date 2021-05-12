package com.example.workouthome.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.workouthome.R
import com.example.workouthome.modules.AdviceTypeItem
import kotlinx.android.synthetic.main.content_recycler_view_advice_type.view.*

class AdviceTypeAdapter(var activity: FragmentActivity?, var arrayList: ArrayList<AdviceTypeItem>) : RecyclerView.Adapter<AdviceTypeAdapter.AdviceTypeViewHolder>() {

    class AdviceTypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.advice_type_title_tv
        var description: TextView = view.advice_type_description_tv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdviceTypeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_recycler_view_advice_type, parent, false)
        return AdviceTypeViewHolder(view)
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    override fun onBindViewHolder(viewHolder: AdviceTypeViewHolder, position: Int) {
        val adviceTypeItem : AdviceTypeItem = arrayList[position]
        viewHolder.title.text = adviceTypeItem.title
        viewHolder.description.text = adviceTypeItem.description
    }
}
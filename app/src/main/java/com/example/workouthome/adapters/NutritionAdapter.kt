package com.example.workouthome.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.workouthome.R
import com.example.workouthome.utils.Constants.DAY_NUMBER

class NutritionAdapter(var activity: Activity, var arrayList: ArrayList<Int> ) : RecyclerView.Adapter<NutritionAdapter.NutritionViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionViewHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.content_recycler_view_nutrition, parent, false)
        return NutritionViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
    override fun onBindViewHolder(viewHolder: NutritionViewHolder, position: Int) {
        viewHolder.day.text = (position + 1).toString()

        viewHolder.itemView.setOnClickListener {
            val bundle = bundleOf(DAY_NUMBER to (position + 1))

            Navigation.findNavController(it)
                .navigate(R.id.action_nutritionFragment_to_dayNutritionFragment, bundle)
        }
    }

    class NutritionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var day: TextView = view.findViewById(R.id.number_day_number)
    }
}
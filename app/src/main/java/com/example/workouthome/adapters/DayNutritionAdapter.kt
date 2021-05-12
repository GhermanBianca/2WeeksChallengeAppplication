package com.example.workouthome.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.workouthome.R
import com.example.workouthome.modules.DayNutritionItem
import kotlinx.android.synthetic.main.content_recycler_view_day_nutrition.view.*

class DayNutritionAdapter(var activity: FragmentActivity?, var arrayList: ArrayList<DayNutritionItem>) : RecyclerView.Adapter<DayNutritionAdapter.DayNutritionViewHolder>() {
    class DayNutritionViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var mealIcon: ImageView = view.meals_image
        var mealName: TextView = view.meals_name
        var dotItem: ImageView = view.meals_dot
        var mealContent: TextView = view.meals_content
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayNutritionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_recycler_view_day_nutrition, parent, false)
        return DayNutritionViewHolder(view)
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    fun updateItems(list: ArrayList<DayNutritionItem>) {
        arrayList.clear()
        arrayList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: DayNutritionViewHolder, position: Int) {
        val dayNutritionItem : DayNutritionItem = arrayList[position]
        viewHolder.mealIcon.setImageResource(dayNutritionItem.meal_icon)
        viewHolder.mealName.text = dayNutritionItem.meal_name
        viewHolder.dotItem.setImageResource(dayNutritionItem.dot_item)
        viewHolder.mealContent.text = dayNutritionItem.meal_content
    }
}
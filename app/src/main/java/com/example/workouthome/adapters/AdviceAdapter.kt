package com.example.workouthome.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.workouthome.R
import com.example.workouthome.modules.AdviceItem
import com.example.workouthome.utils.Constants.DESCRIPTION_IMAGE
import com.example.workouthome.utils.Constants.DESCRIPTION_TYPE
import kotlinx.android.synthetic.main.content_recycler_view_advice.view.*

class AdviceAdapter(var activity: FragmentActivity?, var arrayList: ArrayList<AdviceItem>) :
    RecyclerView.Adapter<AdviceAdapter.AdviceViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdviceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.content_recycler_view_advice, parent, false)
        return AdviceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(viewHolder: AdviceViewHolder, position: Int) {
        val adviceItem: AdviceItem = arrayList[position]

        viewHolder.description.text = adviceItem.description
        viewHolder.icons.setImageResource(adviceItem.icons)

        viewHolder.itemView.setOnClickListener {
            val descriptionText = viewHolder.description.text
            val descriptionImage = adviceItem.icons

            val bundle = bundleOf(DESCRIPTION_TYPE to descriptionText, DESCRIPTION_IMAGE to descriptionImage)

            Navigation.findNavController(it).navigate(R.id.action_adviceFragment_to_adviceTypeFragment, bundle)
        }
    }

    class AdviceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var description: TextView = view.advice_type
        var icons: ImageView= view.image_advice_type
    }
}
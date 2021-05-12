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
import com.example.workouthome.modules.ChallengeItem
import com.example.workouthome.utils.Constants
import kotlinx.android.synthetic.main.content_recycler_view_challenge.view.*

class ChallengeAdapter(var activity: FragmentActivity?, var arrayList: ArrayList<ChallengeItem>) : RecyclerView.Adapter<ChallengeAdapter.ChallengeViewHolder>() {
    class ChallengeViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var dayNumber : TextView = view.challenge_number_day_number
        var descriptionChallenge: TextView = view.description_challenge
        var iconsChallenge: ImageView = view.image_challenge
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_recycler_view_challenge, parent, false)
        return ChallengeViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ChallengeViewHolder, position: Int) {
        val challengeItem: ChallengeItem = arrayList[position]

        viewHolder.dayNumber.text = (position + 1).toString()
        viewHolder.descriptionChallenge.text = challengeItem.description_challenge
        viewHolder.iconsChallenge.setImageResource(challengeItem.icons_challenge)

        viewHolder.itemView.setOnClickListener{
            val bundle = bundleOf(Constants.CHALLENGE_DAY_NUMBER to (position + 1))
            Navigation.findNavController(it).navigate(R.id.action_challengeFragment_to_dayChallengeFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}
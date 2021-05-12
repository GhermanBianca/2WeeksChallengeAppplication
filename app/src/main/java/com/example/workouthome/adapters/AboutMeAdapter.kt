package com.example.workouthome.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.NumberPicker
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workouthome.R
import java.util.*

@Suppress("NAME_SHADOWING")
class AboutMeAdapter(private val dataSet: List<String>, private val activity: Activity) :
    RecyclerView.Adapter<AboutMeAdapter.AboutMeViewHolder>() {

    companion object {
        const val MAX300 = 300
        const val MAX9 = 9
        const val MIN15 = 15
        const val MIN21 = 21
        const val MIN0 = 0
    }

    // logic for details profile from about me
    inner class AboutMeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val aboutMeName: TextView = view.findViewById(R.id.about_me_name)
        val aboutMeValue: TextView = view.findViewById(R.id.about_me_value)

        init {
            aboutMeValue.setCompoundDrawablesWithIntrinsicBounds(
                0, 0, 0, 0
            )

            view.setOnClickListener {
                val position: Int = adapterPosition
                showDialog(position)
            }
        }


        @SuppressLint("SetTextI18n")
        private fun showDialog(position: Int) {
            val d = AlertDialog.Builder(activity)
            val inflater: LayoutInflater = activity.layoutInflater


            when (position) {
                0 -> {
                    aboutMeValue.setCompoundDrawablesWithIntrinsicBounds(
                        0, 0, 0, 0
                    )
                    val dialogView: View = inflater.inflate(R.layout.about_me_height_dialog, null)
                    d.setTitle((activity.getString((R.string.height)).toUpperCase(Locale.ROOT)).toUpperCase(Locale.ROOT))
                    d.setView(dialogView)
                    val numberPicker =
                        dialogView.findViewById<View>(R.id.numberPickerHeight) as NumberPicker
                    numberPicker.maxValue = MAX300
                    numberPicker.minValue = MIN21
                    numberPicker.setOnValueChangedListener { _, _, _ ->
                    }
                    d.setPositiveButton(activity.getString((R.string.save)).toUpperCase(Locale.ROOT)) { _, _ ->
                        aboutMeValue.text = numberPicker.value.toString() + " " + (activity.getString(R.string.cm)).toUpperCase(Locale.ROOT)
                    }
                    d.setNegativeButton((activity.getString((R.string.cancel)).toUpperCase(Locale.ROOT)).toUpperCase(Locale.ROOT)) { _, _ ->
                        aboutMeValue.setCompoundDrawablesWithIntrinsicBounds(
                            0, 0, 0, 0
                        )
                    }
                    val alertDialog = d.create()
                    alertDialog.show()
                }

                1 -> {
                    aboutMeValue.setCompoundDrawablesWithIntrinsicBounds(
                        0, 0, 0, 0
                    )
                    d.setTitle(activity.getString(R.string.weight))
                    val dialogView: View = inflater.inflate(R.layout.about_me_weight_dialog, null)
                    d.setView(dialogView)
                    val firstNumberPicker =
                        dialogView.findViewById<View>(R.id.firstNumberPicker) as NumberPicker
                    firstNumberPicker.maxValue = MAX300
                    firstNumberPicker.minValue = MIN15
                    firstNumberPicker.setOnValueChangedListener { _, _, _ ->
                    }
                    val secondNumberPicker =
                        dialogView.findViewById<View>(R.id.secondNumberPicker) as NumberPicker
                    secondNumberPicker.maxValue = 9
                    secondNumberPicker.minValue = 0
                    secondNumberPicker.setOnValueChangedListener { _, _, _ ->
                    }
                    d.setPositiveButton(
                        activity.getString((R.string.save)).toUpperCase(Locale.ROOT)
                    ) { _, _ ->
                        aboutMeValue.text =
                            firstNumberPicker.value.toString() + "." + secondNumberPicker.value.toString() + " " + activity.getString(
                                (R.string.kg)
                            ).toUpperCase(Locale.ROOT)
                    }
                    d.setNegativeButton(
                        activity.getString((R.string.cancel)).toUpperCase(Locale.ROOT)
                    ) { _, _ ->
                        aboutMeValue.setCompoundDrawablesWithIntrinsicBounds(
                            0, 0, 0, 0
                        )
                    }
                    val alertDialog = d.create()
                    alertDialog.show()
                }

                2 -> {
                    aboutMeValue.setCompoundDrawablesWithIntrinsicBounds(
                        0, 0, 0, 0
                    )
                    d.setTitle(activity.getString((R.string.desired_weight)).toUpperCase(Locale.ROOT))
                    val dialogView: View =
                        inflater.inflate(R.layout.about_me_weight_dialog, null)
                    d.setView(dialogView)
                    val firstNumberPicker =
                        dialogView.findViewById<View>(R.id.firstNumberPicker) as NumberPicker
                    firstNumberPicker.maxValue = MAX300
                    firstNumberPicker.minValue = MIN15
                    firstNumberPicker.setOnValueChangedListener { _, _, _ ->
                    }
                    val secondNumberPicker =
                        dialogView.findViewById<View>(R.id.secondNumberPicker) as NumberPicker
                    secondNumberPicker.maxValue = MAX9
                    secondNumberPicker.minValue = MIN0
                    secondNumberPicker.setOnValueChangedListener { _, _, _ ->
                    }
                    d.setPositiveButton(activity.getString((R.string.save)).toUpperCase(Locale.ROOT))
                    { _, _ ->
                        aboutMeValue.text =
                            firstNumberPicker.value.toString() + "." + secondNumberPicker.value.toString() + " " + activity.getString((R.string.kg)).toUpperCase(
                                Locale.ROOT
                            )
                    }
                    d.setNegativeButton(activity.getString((R.string.cancel)).toUpperCase(Locale.ROOT)) { _, _ ->
                        aboutMeValue.setCompoundDrawablesWithIntrinsicBounds(
                            0, 0, 0, 0
                        )
                    }
                    val alertDialog = d.create()
                    alertDialog.show()
                }

                3 -> {
                    aboutMeValue.setCompoundDrawablesWithIntrinsicBounds(
                        0, 0, 0, 0
                    )
                    d.setTitle(activity.getString((R.string.birthday)).toUpperCase(Locale.ROOT))
                    val dialogView: View =
                        inflater.inflate(R.layout.about_me_date_dialog, null)
                    d.setView(dialogView)
                    val datePicker =
                        dialogView.findViewById<View>(R.id.date_Picker) as DatePicker
                    val today = Calendar.getInstance()
                    datePicker.init(
                        today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                        today.get(Calendar.DAY_OF_MONTH)
                    ) { _, year, month, day ->
                        val month = month + 1
                        aboutMeValue.text = "$day/$month/$year"
                    }
                    d.setPositiveButton(activity.getString((R.string.save)).toUpperCase(Locale.ROOT)) { _, _ ->
                    }
                    d.setNegativeButton(activity.getString((R.string.cancel)).toUpperCase(Locale.ROOT)) { _, _ ->
                        aboutMeValue.setCompoundDrawablesWithIntrinsicBounds(
                            0, 0, 0, 0
                        )
                    }
                    val alertDialog = d.create()
                    alertDialog.show()
                }

                4 -> {
                    aboutMeValue.setCompoundDrawablesWithIntrinsicBounds(
                        0, 0, 0, 0
                    )
                    d.setTitle(activity.getString((R.string.gender)).toUpperCase(Locale.ROOT))
                    var selectedItemIndex = 0
                    val gender = arrayOf(activity.getString(R.string.female), activity.getString(R.string.male))
                    var selectedGender = gender[selectedItemIndex]

                    AlertDialog.Builder(activity)
                        .setTitle("GEN")
                        .setSingleChoiceItems(gender, selectedItemIndex) { _, which ->
                            selectedItemIndex = which
                            selectedGender = gender[which]
                        }
                        .setPositiveButton(activity.getString((R.string.save)).toUpperCase(Locale.ROOT)) { _, _ ->
                            aboutMeValue.text = selectedGender
                        }
                        .setNegativeButton(activity.getString((R.string.cancel)).toUpperCase(Locale.ROOT)) { _, _ ->
                            aboutMeValue.setCompoundDrawablesWithIntrinsicBounds(
                                0, 0, 0, 0
                            )
                        }
                        .show()
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AboutMeViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.content_recycler_view_about_me, viewGroup, false)
        return AboutMeViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: AboutMeViewHolder, position: Int) {
        viewHolder.aboutMeName.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
}
package com.example.workouthome.modules

import android.os.Parcel
import android.os.Parcelable

data class User (
    val id: String  = "",
    val name: String = "",
    val email: String = "",
    val image: String = "",
    val gender: String = "",
    val height: String = "",
    val weight: String = "",
    val dateOfBirth: String = "",
    val desiredWeight: String = "",
    val fcmToken: String = ""
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(dest: Parcel?, flags: Int) = with(dest){
        this!!.writeString(id)
        writeString(name)
        writeString(email)
        writeString(image)
        writeString(gender)
        writeString(height)
        writeString(weight)
        writeString(desiredWeight)
        writeString(dateOfBirth)
        writeString(fcmToken)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
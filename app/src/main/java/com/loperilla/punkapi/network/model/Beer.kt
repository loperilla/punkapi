package com.loperilla.punkapi.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Beer() : Parcelable {
    @SerializedName("name")
    val name: String = ""
    @SerializedName("image_url")
    val image_url: String = ""
    @SerializedName("first_brewed")
    val firstBrewed: String = ""
    @SerializedName("description")
    val description: String = ""

    constructor(parcel: Parcel) : this()

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeString(name)
        parcel.writeString(image_url)
        parcel.writeString(firstBrewed)
        parcel.writeString(description)
    }

    companion object CREATOR : Parcelable.Creator<Beer> {
        override fun createFromParcel(parcel: Parcel): Beer {
            return Beer(parcel)
        }

        override fun newArray(size: Int): Array<Beer?> {
            return arrayOfNulls(size)
        }
    }
}
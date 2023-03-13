package com.example.apiproject

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayerData(
    val id: Int,
    val first_name: String,
    val last_name: String
) : Parcelable

//data class PlayerData(
//val data: Data) :Parcelable{
//@Parcelize
//data class Data (
//val id: Int,
//val first_name: String) Parcelable
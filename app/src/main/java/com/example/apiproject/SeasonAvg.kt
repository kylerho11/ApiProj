package com.example.apiproject
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SeasonAvg(
     val games_played: Int,
     val season: Int,
     val min: String,
     val fga: Double,
     val fgm: Double,
     val reb: Double,
     val ast: Double,
     val stl: Double,
     val turnover: Double,
     val pts: Double,
     val fg_pct: Double
): Parcelable

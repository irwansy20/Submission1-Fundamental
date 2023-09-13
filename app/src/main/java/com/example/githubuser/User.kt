package com.example.githubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var user: String,
    var follow: String,
    var following: String,
    var photo: Int,
    var nama: String,
    var location: String,
    var company: String,
    var repository: String
):Parcelable

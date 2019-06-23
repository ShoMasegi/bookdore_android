package com.sho.masegi.bookdore.domain.model

import com.google.gson.annotations.SerializedName

data class Card(
    val id: Int,
    var status: Status,
    @SerializedName("spent_time_sec") var spentTimeSec: Float,
    @SerializedName("current_page") var currentPage: Int,
    val book: Book,
    val user: User
)

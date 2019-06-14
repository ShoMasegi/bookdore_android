package com.sho.masegi.bookdore.domain.model

import com.squareup.moshi.Json

data class Card(
    val id: Int,
    var status: Status,
    @Json(name = "spent_time_sec") var spentTimeSec: Float,
    @Json(name = "current_page") var currentPage: Int,
    val book: Book,
    val user: User
)

package com.sho.masegi.bookdore.domain.model

data class Book(
    val id: Int,
    val isbn: String,
    val title: String,
    val publisher: String,
    val authors: List<String>,
    val description: String,
    val category: String,
    val thumbnail: String,
    val page: Int
)

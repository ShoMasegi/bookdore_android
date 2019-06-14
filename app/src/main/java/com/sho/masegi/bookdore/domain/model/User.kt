package com.sho.masegi.bookdore.domain.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val admin: Boolean
)

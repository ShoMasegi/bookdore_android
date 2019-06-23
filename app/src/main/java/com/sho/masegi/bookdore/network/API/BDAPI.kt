package com.sho.masegi.bookdore.network.API


sealed class BDAPI {

    object Cards : BDAPI()
}

enum class Method {
    get, post // , put, delete, patch
}


val BDAPI.baseURL: String
    get() = when(this) {
        BDAPI.Cards -> "https://bookdore.herokuapp.com"
    }
val BDAPI.path: String
    get() = when(this) {
        BDAPI.Cards -> "cards.json"
    }
val BDAPI.method: Method
    get() = when(this) {
        BDAPI.Cards -> Method.get
    }
val BDAPI.headers: Map<String, String>?
    get() = when(this) {
        BDAPI.Cards -> mapOf()
    }

fun BDAPI.endpoint(): String = "$baseURL/$path"

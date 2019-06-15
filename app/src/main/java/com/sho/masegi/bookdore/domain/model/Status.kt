package com.sho.masegi.bookdore.domain.model

enum class Status {
    want, bought, reading, read

}

val Status.value: String
    get() = when(this) {
        Status.want -> "Want"
        Status.bought -> "Bought"
        Status.reading -> "Reading Now"
        Status.read -> "Read"
    }

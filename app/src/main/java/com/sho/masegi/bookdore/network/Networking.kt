package com.sho.masegi.bookdore.network

import com.sho.masegi.bookdore.network.API.BDAPI

object Networking {

    val bdapi: BDAPI = Client.retrofit("https://bookdore.herokuapp.com")
                             .create(BDAPI::class.java)
}
package com.sho.masegi.bookdore.network.API

import com.sho.masegi.bookdore.domain.model.Cards
import com.sho.masegi.bookdore.network.ResponseData
import retrofit2.http.GET

interface BDAPI {

    @GET("/cards.json")
    suspend fun cards(): ResponseData<Cards>
}

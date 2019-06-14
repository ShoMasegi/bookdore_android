package com.sho.masegi.bookdore.network.API

import com.sho.masegi.bookdore.domain.model.Cards
import com.sho.masegi.bookdore.network.ResponseData
import retrofit2.http.GET

interface BDAPI {

    // TODO: Rename Type String to CardsScreen
    @GET("/cards.json")
    suspend fun cards(): ResponseData<Cards>
}

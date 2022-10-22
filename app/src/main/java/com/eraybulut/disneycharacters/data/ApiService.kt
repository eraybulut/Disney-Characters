package com.eraybulut.disneycharacters.data

import com.eraybulut.disneycharacters.model.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("characters")
    fun getCharacter(@Query("page") page: Int):Call<CharactersResponse>

}
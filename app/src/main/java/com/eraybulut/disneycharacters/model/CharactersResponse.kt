package com.eraybulut.disneycharacters.model

import com.google.gson.annotations.SerializedName

data class CharactersResponse(

    @SerializedName("data")
    var characterList: List<Results>

)

package com.eraybulut.disneycharacters.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Results(

    @SerializedName("_id")
    var id:String,

    @SerializedName("name")
    var name: String,

    @SerializedName("imageUrl")
    var imageUrl: String,

    @SerializedName("films")
    var films: List<String>,

    @SerializedName("shortFilms")
    var shortFilms: List<String>,

    @SerializedName("tvShows")
    var tvShows:List<String>,

    @SerializedName("videoGames")
    var videoGames:List<String>,

    @SerializedName("allies")
    var allies:List<String>,

    @SerializedName("enemies")
    var enemies:List<String>


):Serializable
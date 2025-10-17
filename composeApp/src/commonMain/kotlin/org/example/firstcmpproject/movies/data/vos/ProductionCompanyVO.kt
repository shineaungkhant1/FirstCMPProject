package org.example.firstcmpproject.movies.data.vos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ProductionCompanyVO (
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("logo_path")
    val logoPath: String,

    @SerialName("origin_country")
    val originCountry: String
)
//{
//    "id": 174,
//    "logo_path": "/kgJaIcKZZK4lTazer55XrgWDEvp.png",
//    "name": "Warner Bros. Pictures",
//    "origin_country": "US"
//},
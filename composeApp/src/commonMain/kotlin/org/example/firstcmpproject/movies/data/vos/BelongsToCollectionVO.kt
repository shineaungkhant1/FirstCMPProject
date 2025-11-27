package org.example.firstcmpproject.movies.data.vos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BelongsToCollectionVO (
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("poster_path")
    val posterPath: String?,

    @SerialName("backdrop_path")
    val backdropPath: String?
)

//
//"belongs_to_collection": {
//    "id": 468552,
//    "name": "Wonder Woman Collection",
//    "poster_path": "/8AQRfTuTHeFTddZN4IUAqprN8Od.jpg",
//    "backdrop_path": "/n9KlvCOBFDmSyw3BgNrkUkxMFva.jpg"
//},
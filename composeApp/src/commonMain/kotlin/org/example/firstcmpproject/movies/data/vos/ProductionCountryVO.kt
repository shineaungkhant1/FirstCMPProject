package org.example.firstcmpproject.movies.data.vos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ProductionCountryVO (
    @SerialName("iso_3166_1")
    val iso31661: String,

    @SerialName("name")
    val name: String,

)

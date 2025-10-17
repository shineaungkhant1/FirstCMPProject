package org.example.firstcmpproject.movies.data.vos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SpokenLanguageVO (
    @SerialName("english_name")
    val englishName: String,

    @SerialName("name")
    val name: String,

    @SerialName("iso_639_1")
    val iso6391: String,

)

//"english_name": "English",
//"iso_639_1": "en",
//"name": "English"
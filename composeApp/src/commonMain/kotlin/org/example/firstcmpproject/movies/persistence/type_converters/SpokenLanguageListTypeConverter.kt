package org.example.firstcmpproject.movies.persistence.type_converters

import androidx.room.TypeConverter
import org.example.firstcmpproject.core.utils.universalJsonParser
import org.example.firstcmpproject.movies.data.vos.BelongsToCollectionVO
import org.example.firstcmpproject.movies.data.vos.GenreVO
import org.example.firstcmpproject.movies.data.vos.SpokenLanguageVO

class SpokenLanguageListTypeConverter {
    @TypeConverter
    fun fromSpokenLanguagesList(spokenLanguagesList: List<SpokenLanguageVO>?): String? {
        return spokenLanguagesList?.let {
            universalJsonParser.encodeToString(it)
        }
    }

    @TypeConverter
    fun toSpokenLanguagesList(jsonString: String?): List<SpokenLanguageVO>? {
        return jsonString?.let {
            universalJsonParser.decodeFromString(it)
        }
    }
}

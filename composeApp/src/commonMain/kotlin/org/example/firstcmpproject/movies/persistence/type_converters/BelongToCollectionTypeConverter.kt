package org.example.firstcmpproject.movies.persistence.type_converters

import androidx.room.TypeConverter
import org.example.firstcmpproject.core.utils.universalJsonParser
import org.example.firstcmpproject.movies.data.vos.BelongsToCollectionVO

class BelongToCollectionTypeConverter {
    @TypeConverter
    fun fromBelongsToCollection(belongToCollection: BelongsToCollectionVO?): String? {
        return belongToCollection?.let {
            universalJsonParser.encodeToString(it)
        }
    }

    @TypeConverter
    fun toBelongsToCollection(belongToCollectionString: String?): BelongsToCollectionVO? {
        return belongToCollectionString?.let {
            universalJsonParser.decodeFromString(it)
        }
    }
}

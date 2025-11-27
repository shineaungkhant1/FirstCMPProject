package org.example.firstcmpproject.movies.persistence.type_converters

import androidx.room.TypeConverter
import org.example.firstcmpproject.core.utils.universalJsonParser
import org.example.firstcmpproject.movies.data.vos.GenreVO
import org.example.firstcmpproject.movies.data.vos.ProductionCompanyVO
import org.example.firstcmpproject.movies.data.vos.ProductionCountryVO

class ProductionCountryListTypeConverter {
    @TypeConverter
    fun fromProductionCountryList(productionCountryList: List<ProductionCountryVO>?): String? {
        return productionCountryList?.let {
            universalJsonParser.encodeToString(it)
        }
    }

    @TypeConverter
    fun toProductionCountryList(jsonString: String?): List<ProductionCountryVO>? {
        return jsonString?.let {
            universalJsonParser.decodeFromString(it)
        }
    }
}

package org.example.firstcmpproject.movies.persistence.type_converters

import androidx.room.TypeConverter
import org.example.firstcmpproject.core.utils.universalJsonParser
import org.example.firstcmpproject.movies.data.vos.GenreVO
import org.example.firstcmpproject.movies.data.vos.ProductionCompanyVO

class ProductionCompanyListTypeConverter {
    @TypeConverter
    fun fromProductionCompanyList(productionCompanyList: List<ProductionCompanyVO>?): String? {
        return productionCompanyList?.let {
            universalJsonParser.encodeToString(it)
        }
    }

    @TypeConverter
    fun toProductionCompanyList(jsonString: String?): List<ProductionCompanyVO>? {
        return jsonString?.let {
            universalJsonParser.decodeFromString(it)
        }
    }
}

package de.akquinet.ccsp.floodwatch.datamodel

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class MeasurementImport(val source: String,
                             @field:Indexed val timeOfCreation: Date) {
    var id: String? = null
}

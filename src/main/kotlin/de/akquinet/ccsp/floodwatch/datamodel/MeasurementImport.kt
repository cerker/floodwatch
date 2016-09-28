package de.akquinet.ccsp.floodwatch.datamodel

import lombok.Data
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
@Data
class MeasurementImport(var source: String, @field:Indexed var timeOfCreation: Date) {
    var id: String? = null
}

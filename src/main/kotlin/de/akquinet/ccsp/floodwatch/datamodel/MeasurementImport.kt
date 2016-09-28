package de.akquinet.ccsp.floodwatch.datamodel

import lombok.Data
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
@Data
class MeasurementImport(val source: String,
                        @field:Indexed val timeOfCreation: Date) {
    var id: String? = null
}

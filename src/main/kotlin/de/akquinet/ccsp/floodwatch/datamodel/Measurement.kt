package de.akquinet.ccsp.floodwatch.datamodel

import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Measurement(@field:DBRef val measurementImport: MeasurementImport,
                       @field:DBRef val location: Location,
                       val timeOfMeasurement: Date) {
    var id: String? = null
    var waterLevelInCm: Int? = null
    var waterLevelGroup: String? = null
    var throughFlowInCubicMetersPerSecond: Float? = null
    var throughFlowGroup: String? = null
    var waterTemperatureInCelsius: Float? = null
}

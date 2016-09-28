package de.akquinet.ccsp.floodwatch.datamodel

import java.util.*

object MeasurementMother {

    fun create(location: Location, measurementImport: MeasurementImport): Measurement {
        val measurement = Measurement(measurementImport, location, Date(0))
        measurement.throughFlowGroup = "mali pretok"
        measurement.throughFlowInCubicMetersPerSecond = 1.03f
        measurement.waterLevelGroup = "srednji vodostaj"
        measurement.waterLevelInCm = 240
        measurement.waterTemperatureInCelsius = 16.5f
        return measurement
    }
}
package de.akquinet.ccsp.floodwatch.datamodel

import java.util.*

object MeasurementImportMother {

    fun create(): MeasurementImport {
        return MeasurementImport("source", Date(0))
    }
}
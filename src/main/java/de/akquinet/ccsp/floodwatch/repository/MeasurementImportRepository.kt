package de.akquinet.ccsp.floodwatch.repository

import de.akquinet.ccsp.floodwatch.datamodel.MeasurementImport
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface MeasurementImportRepository : MongoRepository<MeasurementImport, String> {

    fun findByTimeOfCreation(timeOfCreation: Date): MeasurementImport
}

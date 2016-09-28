package de.akquinet.ccsp.floodwatch.repository

import de.akquinet.ccsp.floodwatch.datamodel.Measurement
import org.springframework.data.mongodb.repository.MongoRepository

interface MeasurementRepository : MongoRepository<Measurement, String>

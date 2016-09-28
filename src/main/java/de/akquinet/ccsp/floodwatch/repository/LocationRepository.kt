package de.akquinet.ccsp.floodwatch.repository

import de.akquinet.ccsp.floodwatch.datamodel.Location
import org.springframework.data.mongodb.repository.MongoRepository

interface LocationRepository : MongoRepository<Location, String>

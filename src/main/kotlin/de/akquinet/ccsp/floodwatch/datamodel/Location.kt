package de.akquinet.ccsp.floodwatch.datamodel

import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Location(val externalId: String,
                    val geoLocation: GeoJsonPoint,
                    val waterBody: String,
                    val surveyStation: String,
                    val displayName: String) {
    var id: String? = null
    var altitude: Float? = null
}

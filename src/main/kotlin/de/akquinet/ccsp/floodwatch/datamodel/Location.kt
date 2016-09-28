package de.akquinet.ccsp.floodwatch.datamodel

import lombok.Data
import org.springframework.data.mongodb.core.geo.GeoJsonPoint
import org.springframework.data.mongodb.core.mapping.Document

@Document
@Data
class Location(var externalId: String,
               var geoLocation: GeoJsonPoint,
               var waterBody: String,
               var surveyStation: String,
               var displayName: String) {
    var id: String? = null
    var altitude: Float? = null
}


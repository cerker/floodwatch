package de.akquinet.ccsp.floodwatch.datamodel

import org.springframework.data.mongodb.core.geo.GeoJsonPoint

object LocationMother {

    fun create(): Location {
        val location = Location("5479", GeoJsonPoint(46.045512, 14.451169), "Gradaščica", "Bokalce", "Gradaščica - Bokalce")
        location.altitude = 296.63f
        return location
    }
}
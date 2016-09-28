package de.akquinet.ccsp.floodwatch.datamodel;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

public final class LocationMother {

    private LocationMother() {
    }

    public static Location create() {
        Location location = new Location("5479", new GeoJsonPoint(46.045512f, 14.451169f), "Gradaščica", "Bokalce", "Gradaščica - Bokalce");
        location.setAltitude(296.63f);
        return location;
    }
}
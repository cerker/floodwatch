package de.akquinet.ccsp.floodwatch.datamodel;

import lombok.Data;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Location {

    private String id;

    private final String externalId;

    private final GeoJsonPoint geoLocation;

    private float altitude;

    private final String waterBody;

    private final String surveyStation;

    private final String displayName;
}

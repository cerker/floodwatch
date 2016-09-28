package de.akquinet.ccsp.floodwatch.datamodel;

import java.util.Date;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Measurement {

    private String id;

    @DBRef
    private final MeasurementImport measurementImport;

    @DBRef
    private final Location location;

    private final Date timeOfMeasurement;

    private int waterLevelInCm;

    private String waterLevelGroup;

    private float throughFlowInCubicMetersPerSecond;

    private String throughFlowGroup;

    private float waterTemperatureInCelsius;
}

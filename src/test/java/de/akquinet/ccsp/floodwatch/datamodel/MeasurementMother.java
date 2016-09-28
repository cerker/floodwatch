package de.akquinet.ccsp.floodwatch.datamodel;

import java.util.Date;

public final class MeasurementMother {

    private MeasurementMother() {
    }

    public static Measurement create(Location location, MeasurementImport measurementImport) {
        Measurement measurement = new Measurement(measurementImport, location, new Date(0));
        measurement.setThroughFlowGroup("mali pretok");
        measurement.setThroughFlowInCubicMetersPerSecond(1.03f);
        measurement.setWaterLevelGroup("srednji vodostaj");
        measurement.setWaterLevelInCm(240);
        measurement.setWaterTemperatureInCelsius(16.5f);
        return measurement;
    }
}
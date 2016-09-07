package de.akquinet.ccsp.floodmark.datamodel;

import java.util.Date;

public final class MeasurementImportMother {

    private MeasurementImportMother() {
    }

    public static MeasurementImport create() {
        return new MeasurementImport("source", new Date(0));
    }
}
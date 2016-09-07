package de.akquinet.ccsp.floodmark.repository;

import de.akquinet.ccsp.floodmark.datamodel.MeasurementImport;
import java.util.Date;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeasurementImportRepository extends MongoRepository<MeasurementImport, String> {

    MeasurementImport findByTimeOfCreation(Date timeOfCreation);
}

package de.akquinet.ccsp.floodmark.repository;

import de.akquinet.ccsp.floodmark.datamodel.Measurement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeasurementRepository extends MongoRepository<Measurement, String> {

}

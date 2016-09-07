package de.akquinet.ccsp.floodmark.repository;

import de.akquinet.ccsp.floodmark.datamodel.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {

}

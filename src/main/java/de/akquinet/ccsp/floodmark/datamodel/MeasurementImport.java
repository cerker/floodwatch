package de.akquinet.ccsp.floodmark.datamodel;

import java.util.Date;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class MeasurementImport {

    private String id;

    private final String source;

    @Indexed(unique = true)
    private final Date timeOfCreation;
}

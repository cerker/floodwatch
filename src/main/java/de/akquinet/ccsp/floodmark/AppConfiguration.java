package de.akquinet.ccsp.floodmark;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class AppConfiguration extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "e-store";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }

    @Override
    protected String getMappingBasePackage() {
        return "de.akquinet.ccsp.floodmark.datamodel";
    }
}

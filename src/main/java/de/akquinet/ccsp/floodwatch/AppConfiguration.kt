package de.akquinet.ccsp.floodwatch

import com.mongodb.Mongo
import com.mongodb.MongoClient
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories
open class AppConfiguration : AbstractMongoConfiguration() {

    override fun getDatabaseName(): String {
        return "e-store"
    }

    @Throws(Exception::class)
    override fun mongo(): Mongo {
        return MongoClient()
    }

    override fun getMappingBasePackage(): String {
        return "de.akquinet.ccsp.floodwatch.datamodel"
    }
}

package de.akquinet.ccsp.floodwatch

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
open class AppConfiguration {
    @Bean @Primary
    open fun xmlMapperBuilder(): XmlMapper {
        val xmlMapper = XmlMapper()
        xmlMapper.registerModule(KotlinModule())
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        return xmlMapper
    }
}

package de.akquinet.ccsp.floodwatch.integration

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

@Component
open class ArsoImportRoutes : RouteBuilder() {

    override fun configure() {
        from("timer://arsoImport?fixedRate=true&delay=0&period=30s")
                .to("http4://www.arso.gov.si/xml/vode/hidro_podatki_zadnji.xml")
                .convertBodyTo(String::class.java)
                .to("log:de.akquinet.ccsp.floodwatch.integration.ROUTE?level=INFO")
    }
}

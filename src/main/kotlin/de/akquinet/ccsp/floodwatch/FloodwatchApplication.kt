package de.akquinet.ccsp.floodwatch

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class FloodwatchApplication {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(FloodwatchApplication::class.java, *args)
        }
    }
}
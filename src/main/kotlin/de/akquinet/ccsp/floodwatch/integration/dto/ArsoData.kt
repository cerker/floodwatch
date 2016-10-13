package de.akquinet.ccsp.floodwatch.integration.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.time.ZonedDateTime

@JacksonXmlRootElement(localName = "arsopodatki")
@JsonIgnoreProperties(ignoreUnknown = true)
data class ArsoData(

        /**
         * Version of XML schema, e.g. "1.0"
         */
        @field:JacksonXmlProperty(localName = "verzija", isAttribute = true) val xmlVersion: String,

        /**
         * Source of data, e.g. "Agencija RS za okolje"
         */
        @field:JacksonXmlProperty(localName = "vir") val source: String,

        /**
         * Proposed time of data collection, e.g. "5 minut cez polno uro ali pol ure" ("5 minutes after full or half hour")
         */
        @field:JacksonXmlProperty(localName = "predlagan_zajem") val proposedCollectionTime: String,

        /**
         * Proposed time interval for data collection, e.g. "30 min"
         */
        @field:JacksonXmlProperty(localName = "predlagan_zajem_perioda") val proposedCollectionInterval: String,

        /**
         * Date and time of the creation of this XML file, e.g. "2016-10-07 13:01".
         * Relative to time zone "Europe/Ljubljana"
         */
        @field:JsonDeserialize(using = ArsoDateTimeDeserializer::class)
        @field:JacksonXmlProperty(localName = "datum_priprave") val timeOfCreation: ZonedDateTime,

        /**
         * Measurement data for each station
         */
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "postaja") var stationList: List<Station>
)

data class Station(
        /**
         * Code of station - unique, e.g. 5479
         */
        @field:JacksonXmlProperty(localName = "sifra", isAttribute = true) val code: String,

        /**
         * Geographic longitude, e.g. 14.451169
         */
        @field:JacksonXmlProperty(localName = "ge_dolzina", isAttribute = true) val longitude: Double,

        /**
         * Geographic latitude, e.g. 46.045512
         */
        @field:JacksonXmlProperty(localName = "ge_sirina", isAttribute = true) val latitude: Double,

        /**
         * Geometric height in meters above sea level of Adriatic sea, e.g. 296.63
         */
        @field:JacksonXmlProperty(localName = "kota_0", isAttribute = true) val elevation: Double?,

        /**
         * Name of river, lake or sea, e.g. "Sava", "Jadransko morje"
         */
        @field:JacksonXmlProperty(localName = "reka") val waterBody: String,

        /**
         * Name of maesuring point, e.g. "Radovljica"
         */
        @field:JacksonXmlProperty(localName = "merilno_mesto") val measuringPoint: String,

        /**
         * Abbreviated name consisting of the water body name and the measuring point, e.g. Sava - Radovljica
         */
        @field:JacksonXmlProperty(localName = "ime_kratko") val shortName: String,

        /**
         * Date and time of measurement, e.g. "2016-10-07 12:30".
         * Relative to time zone "Europe/Ljubljana"
         */
        @field:JsonDeserialize(using = ArsoDateTimeDeserializer::class)
        @field:JacksonXmlProperty(localName = "datum") val timeOfMeasurement: ZonedDateTime,

        /**
         * Flow rate in m3/s, e.g. 23.9
         */
        @field:JacksonXmlProperty(localName = "pretok") val pretok: Double?,

        /**
         * Information about which group of significant flows spade current flow
         *
         * Possible values:
         * - "mali pretok" (low flow)
         * - "srednji pretok" (medium flow)
         * - "velik pretok" (large flow)
         * - "opozorilni pretok" (alarming flow)
         */
        @field:JacksonXmlProperty(localName = "pretok_znacilni") val pretokZnacilni: String?,

        /**
         * Height of the water level in cm
         */
        @field:JacksonXmlProperty(localName = "vodostaj") val vodostaj: Int?,

        /**
         * Group of current water level
         *
         * Possible values:
         * - nizek vodostaj (low water level)
         * - srednji vodostaj (normal water level)
         * - visok vodostaj (high water level)
         * - opozorilni vodostaj (alarming water level)
         * Data is only available for the measurement location "Adriatic Sea - Koper".
         */
        @field:JacksonXmlProperty(localName = "vodostaj_znacilni") val vodostajZnacilni: String?,

        /**
         * Water temperature in degrees celsius, e.g. 9.4
         */
        @field:JacksonXmlProperty(localName = "temp_vode") val tempVode: Double?
)

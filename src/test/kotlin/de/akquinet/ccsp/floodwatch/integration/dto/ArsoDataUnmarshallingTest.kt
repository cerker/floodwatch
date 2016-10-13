package de.akquinet.ccsp.floodwatch.integration.dto

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import de.akquinet.ccsp.floodwatch.AppConfiguration
import org.amshove.kluent.`should be`
import org.amshove.kluent.`should equal`
import org.amshove.kluent.`should not be`
import org.junit.Test
import java.time.Month
import java.time.ZoneId
import java.time.ZonedDateTime

class ArsoDataUnmarshallingTest {

    val mapper: XmlMapper = AppConfiguration().xmlMapperBuilder()

    @Test
    fun unmarshallsArsoData() {
        val data = mapper.readValue(this.javaClass.getResource("/arso.xml"), ArsoData::class.java)

        data `should not be` null
        data.timeOfCreation `should equal` ZonedDateTime.of(2016, Month.OCTOBER.value, 7, 13, 1, 0, 0, ZoneId.of("Europe/Ljubljana"))
        data.stationList.size `should equal` 173
        data.proposedCollectionTime `should equal` "5 minut \u010dez polno uro ali pol ure"
        data.proposedCollectionInterval `should equal` "30 min"
        data.source `should equal` "Agencija RS za okolje"
        data.xmlVersion `should equal` "1.0"

        println(data)
    }

    @Test
    fun unmarshallsRiverStation() {
        val data = mapper.readValue(this.javaClass.getResource("/arso.xml"), ArsoData::class.java)

        val stationIndex = 0
        data.stationList[stationIndex].code `should equal` "1060"
        data.stationList[stationIndex].longitude `should equal` 16.000253
        data.stationList[stationIndex].latitude `should equal` 46.68151
        data.stationList[stationIndex].elevation `should equal` 202.34
        data.stationList[stationIndex].waterBody `should equal` "Mura"
        data.stationList[stationIndex].measuringPoint `should equal` "Gornja Radgona"
        data.stationList[stationIndex].shortName `should equal` "Mura - Gor. Radgona"
        data.stationList[stationIndex].timeOfMeasurement `should equal` ZonedDateTime.of(2016, Month.OCTOBER.value, 7, 12, 30, 0, 0, ZoneId.of("Europe/Ljubljana"))
        data.stationList[stationIndex].pretok `should equal` 100.0
        data.stationList[stationIndex].pretokZnacilni `should equal` "srednji pretok"
        data.stationList[stationIndex].vodostaj `should equal` 89
        data.stationList[stationIndex].vodostajZnacilni `should be` null
        data.stationList[stationIndex].tempVode `should equal` 11.5
    }

    @Test
    fun unmarshallsSeaStation() {
        val data = mapper.readValue(this.javaClass.getResource("/arso.xml"), ArsoData::class.java)

        val stationIndex = 170
        data.stationList[stationIndex].code `should equal` "9400"
        data.stationList[stationIndex].longitude `should equal` 13.550017
        data.stationList[stationIndex].latitude `should equal` 45.551116
        data.stationList[stationIndex].elevation `should be` null
        data.stationList[stationIndex].waterBody `should equal` "Jadransko morje"
        data.stationList[stationIndex].measuringPoint `should equal` "OB Piran (NIB)"
        data.stationList[stationIndex].shortName `should equal` "Jadransko morje - boja Piran (NIB)"
        data.stationList[stationIndex].timeOfMeasurement `should equal` ZonedDateTime.of(2016, Month.OCTOBER.value, 7, 12, 30, 0, 0, ZoneId.of("Europe/Ljubljana"))
        data.stationList[stationIndex].pretok `should be` null
        data.stationList[stationIndex].pretokZnacilni `should be` null
        data.stationList[stationIndex].vodostaj `should be` null
        data.stationList[stationIndex].vodostajZnacilni `should be` null
        data.stationList[stationIndex].tempVode `should equal` 21.1
    }
}
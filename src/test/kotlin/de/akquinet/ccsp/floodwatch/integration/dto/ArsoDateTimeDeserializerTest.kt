package de.akquinet.ccsp.floodwatch.integration.dto

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import de.akquinet.ccsp.floodwatch.AppConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.time.ZonedDateTime

class ArsoDateTimeDeserializerTest {

    @Test
    fun deserializesDateTimeInArsoFormat() {
        val mapper: XmlMapper = AppConfiguration().xmlMapperBuilder()

        val root = mapper.readValue("<root><date>2016-10-07 13:01</date></root>", Root::class.java)

        assertThat(root.date).isEqualTo(ZonedDateTime.parse("2016-10-07T13:01+02:00[Europe/Ljubljana]"))
    }

    data class Root(@field:JsonDeserialize(using = ArsoDateTimeDeserializer::class) val date: ZonedDateTime?) {
        constructor() : this(null)

    }
}
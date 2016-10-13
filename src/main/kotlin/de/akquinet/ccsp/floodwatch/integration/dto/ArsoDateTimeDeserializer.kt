package de.akquinet.ccsp.floodwatch.integration.dto

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

class ArsoDateTimeDeserializer : JsonDeserializer<ZonedDateTime>() {
    val FORMATTER = DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .appendLiteral(' ')
            .append(DateTimeFormatter.ISO_LOCAL_TIME)
            .toFormatter()
            .withZone(ZoneId.of("Europe/Ljubljana"))

    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): ZonedDateTime {
        val node = jp.getCodec().readTree<JsonNode>(jp)
        val value = node.asText()
        val localDateTime = LocalDateTime.parse(value, FORMATTER)
        return ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Ljubljana"))
    }

}
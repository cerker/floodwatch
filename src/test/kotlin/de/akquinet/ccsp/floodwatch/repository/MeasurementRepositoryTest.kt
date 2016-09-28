package de.akquinet.ccsp.floodwatch.repository

import de.akquinet.ccsp.floodwatch.FloodwatchApplication
import de.akquinet.ccsp.floodwatch.datamodel.LocationMother
import de.akquinet.ccsp.floodwatch.datamodel.MeasurementImportMother
import de.akquinet.ccsp.floodwatch.datamodel.MeasurementMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(FloodwatchApplication::class))
class MeasurementRepositoryTest {

    @Autowired
    lateinit var repository: MeasurementRepository

    @Autowired
    lateinit var locationRepository: LocationRepository

    @Autowired
    lateinit var importRepository: MeasurementImportRepository

    @Test
    @Throws(Exception::class)
    fun persistsMeasurement() {
        val location = locationRepository.save(LocationMother.create())
        val measurementImport = importRepository.save(importRepository.save(MeasurementImportMother.create()))
        val measurement = MeasurementMother.create(location, measurementImport)
        repository.save(measurement)

        val measurementFound = repository.findOne(measurement.id)

        assertThat(measurementFound).isEqualToComparingFieldByFieldRecursively(measurement)
    }

    @Before @After
    @Throws(Exception::class)
    fun deleteTestData() {
        repository.deleteAll()
        locationRepository.deleteAll()
        importRepository.deleteAll()
    }
}
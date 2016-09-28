package de.akquinet.ccsp.floodwatch.repository

import de.akquinet.ccsp.floodwatch.FloodwatchApplication
import de.akquinet.ccsp.floodwatch.datamodel.MeasurementImportMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.util.*

@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = arrayOf(FloodwatchApplication::class))
class MeasurementImportRepositoryTest {

    @Autowired
    lateinit var repository: MeasurementImportRepository

    @Test
    fun findsImportByTimeOfCreation() {
        val measurementImport = MeasurementImportMother.create()
        repository.save(measurementImport)

        val measurementImportFound = repository.findByTimeOfCreation(measurementImport.timeOfCreation)

        assertThat(measurementImportFound).isEqualToComparingFieldByField(measurementImport)
    }

    @Test
    fun findsNoImportByTimeOfCreationWhenItDoesNotExist() {
        repository.save(MeasurementImportMother.create())

        val measurementImport = repository.findByTimeOfCreation(Date())

        assertThat(measurementImport).isNull()
    }

    @Before @After
    @Throws(Exception::class)
    fun tearDown() {
        repository.deleteAll()
    }
}
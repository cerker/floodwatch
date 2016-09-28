package de.akquinet.ccsp.floodwatch.repository

import de.akquinet.ccsp.floodwatch.FloodwatchApplication
import de.akquinet.ccsp.floodwatch.datamodel.LocationMother
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
class LocationRepositoryTest {

    @Autowired
    lateinit var repository: LocationRepository

    @Test
    @Throws(Exception::class)
    fun persistsLocation() {
        val location = LocationMother.create()
        repository.save(location)

        val locationFound = repository.findOne(location.id)

        assertThat(locationFound).isEqualToComparingFieldByField(location)
    }

    @Before @After
    @Throws(Exception::class)
    fun tearDown() {
        repository.deleteAll()
    }
}
package de.akquinet.ccsp.floodwatch.repository;

import de.akquinet.ccsp.floodwatch.FloodwatchApplication;
import de.akquinet.ccsp.floodwatch.datamodel.Location;
import de.akquinet.ccsp.floodwatch.datamodel.LocationMother;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FloodwatchApplication.class)
public class LocationRepositoryTest {

    @Autowired
    private LocationRepository repository;

    @Test
    public void persistsLocation() throws Exception {
        Location location = LocationMother.create();
        repository.save(location);

        Location locationFound = repository.findOne(location.getId());

        assertThat(locationFound).isEqualToComparingFieldByField(location);
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }
}
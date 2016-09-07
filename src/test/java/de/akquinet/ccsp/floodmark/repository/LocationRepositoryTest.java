package de.akquinet.ccsp.floodmark.repository;

import de.akquinet.ccsp.floodmark.FloodmarkApplication;
import de.akquinet.ccsp.floodmark.datamodel.Location;
import de.akquinet.ccsp.floodmark.datamodel.LocationMother;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FloodmarkApplication.class)
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
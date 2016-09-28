package de.akquinet.ccsp.floodwatch.repository;

import de.akquinet.ccsp.floodwatch.FloodwatchApplication;
import de.akquinet.ccsp.floodwatch.datamodel.Location;
import de.akquinet.ccsp.floodwatch.datamodel.LocationMother;
import de.akquinet.ccsp.floodwatch.datamodel.Measurement;
import de.akquinet.ccsp.floodwatch.datamodel.MeasurementImport;
import de.akquinet.ccsp.floodwatch.datamodel.MeasurementImportMother;
import de.akquinet.ccsp.floodwatch.datamodel.MeasurementMother;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FloodwatchApplication.class)
public class MeasurementRepositoryTest {

    @Autowired
    private MeasurementRepository repository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private MeasurementImportRepository importRepository;

    @Test
    public void persistsMeasurement() throws Exception {
        Location location = locationRepository.save(LocationMother.INSTANCE.create());
        MeasurementImport measurementImport = importRepository.save(importRepository.save(MeasurementImportMother.INSTANCE.create()));
        Measurement measurement = MeasurementMother.create(location, measurementImport);
        repository.save(measurement);

        Measurement measurementFound = repository.findOne(measurement.getId());

        assertThat(measurementFound).isEqualToComparingFieldByFieldRecursively(measurement);
    }

    @Before
    @After
    public void deleteTestData() throws Exception {
        repository.deleteAll();
        locationRepository.deleteAll();
        importRepository.deleteAll();
    }
}
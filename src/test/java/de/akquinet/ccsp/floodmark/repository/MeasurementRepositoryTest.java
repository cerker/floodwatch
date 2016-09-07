package de.akquinet.ccsp.floodmark.repository;

import de.akquinet.ccsp.floodmark.FloodmarkApplication;
import de.akquinet.ccsp.floodmark.datamodel.Location;
import de.akquinet.ccsp.floodmark.datamodel.LocationMother;
import de.akquinet.ccsp.floodmark.datamodel.Measurement;
import de.akquinet.ccsp.floodmark.datamodel.MeasurementImport;
import de.akquinet.ccsp.floodmark.datamodel.MeasurementImportMother;
import de.akquinet.ccsp.floodmark.datamodel.MeasurementMother;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FloodmarkApplication.class)
public class MeasurementRepositoryTest {

    @Autowired
    private MeasurementRepository repository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private MeasurementImportRepository importRepository;

    @Test
    public void persistsMeasurement() throws Exception {
        Location location = locationRepository.save(LocationMother.create());
        MeasurementImport measurementImport = importRepository.save(importRepository.save(MeasurementImportMother.create()));
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
package de.akquinet.ccsp.floodwatch.repository;

import de.akquinet.ccsp.floodwatch.FloodwatchApplication;
import de.akquinet.ccsp.floodwatch.datamodel.MeasurementImport;
import de.akquinet.ccsp.floodwatch.datamodel.MeasurementImportMother;
import java.util.Date;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FloodwatchApplication.class)
public class MeasurementImportRepositoryTest {

    @Autowired
    private MeasurementImportRepository repository;

    @Test
    public void findsImportByTimeOfCreation() {
        MeasurementImport measurementImport = MeasurementImportMother.INSTANCE.create();
        repository.save(measurementImport);

        MeasurementImport measurementImportFound = repository.findByTimeOfCreation(measurementImport.getTimeOfCreation());

        assertThat(measurementImportFound).isEqualToComparingFieldByField(measurementImport);
    }

    @Test
    public void findsNoImportByTimeOfCreationWhenItDoesNotExist() {
        repository.save(MeasurementImportMother.INSTANCE.create());

        MeasurementImport measurementImport = repository.findByTimeOfCreation(new Date());

        assertThat(measurementImport).isNull();
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }
}
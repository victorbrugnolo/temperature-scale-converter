package dev.victorbrugnolo.temperaturescaleconverter.api.repositories;

import dev.victorbrugnolo.temperaturescaleconverter.api.entities.History;
import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class HistoryRepositoryTest {

    private static final double ORIGINAL_VALUE = 50;
    private static final double CONVERTED_VALUE = 122;
    private static final TemperatureEnum ORIGINAL_SCALE_TEMP = TemperatureEnum.CELSIUS;
    private static final TemperatureEnum CONVERTED_TO = TemperatureEnum.FARENHEIT;
    private static final double ORIGINAL_VALUE_1 = 122;
    private static final double CONVERTED_VALUE_1 = 50;
    private static final TemperatureEnum ORIGINAL_SCALE_TEMP_1 = TemperatureEnum.FARENHEIT;
    private static final TemperatureEnum CONVERTED_TO_1 = TemperatureEnum.CELSIUS;

    @Autowired
    private HistoryRepository historyRepository;

    @Before
    public void setUp() {
        historyRepository.save(new History(ORIGINAL_VALUE, CONVERTED_VALUE, ORIGINAL_SCALE_TEMP, CONVERTED_TO));
        historyRepository.save(new History(ORIGINAL_VALUE_1, CONVERTED_VALUE_1, ORIGINAL_SCALE_TEMP_1, CONVERTED_TO_1));
    }

    @Test
    public void shouldBeGetAll() {
        List<History> saved = historyRepository.findAll();
        assertEquals(2, saved.size());
    }

    @Test
    public void shouldBeGetById() {
        Optional<History> saved = historyRepository.findById(1);
        assertEquals(ORIGINAL_SCALE_TEMP, saved.get().getOriginalScaleTemp());
    }

    @Test
    public void shouldBeSave() {
        History toSave =  historyRepository.save(new History(ORIGINAL_VALUE, CONVERTED_VALUE, ORIGINAL_SCALE_TEMP, CONVERTED_TO));
        assertNotNull(toSave);
    }

    @Test
    public void shouldBeUpdate() {
        Optional<History> toUpdate = historyRepository.findById(2);
        toUpdate.get().setConvertedTo(TemperatureEnum.FARENHEIT);
        toUpdate.get().setOriginalScaleTemp(TemperatureEnum.CELSIUS);
        History updated = historyRepository.save(toUpdate.get());
        assertEquals(TemperatureEnum.FARENHEIT, updated.getConvertedTo());
    }

    @Test
    public void shouldBeDelete() {
        historyRepository.deleteById(1);
        List<History> saved = historyRepository.findAll();
        assertEquals(1, saved.size());
    }

}

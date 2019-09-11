package dev.victorbrugnolo.temperaturescaleconverter.api.services;

import dev.victorbrugnolo.temperaturescaleconverter.api.entities.History;
import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;
import dev.victorbrugnolo.temperaturescaleconverter.api.repositories.HistoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class HistoryServiceTests {

    private static final double ORIGINAL_VALUE = 50;
    private static final double CONVERTED_VALUE = 122;
    private static final TemperatureEnum ORIGINAL_SCALE_TEMP = TemperatureEnum.CELSIUS;
    private static final TemperatureEnum CONVERTED_TO = TemperatureEnum.FARENHEIT;
    private static final double ORIGINAL_VALUE_1 = 122;
    private static final double CONVERTED_VALUE_1 = 50;
    private static final TemperatureEnum ORIGINAL_SCALE_TEMP_1 = TemperatureEnum.FARENHEIT;
    private static final TemperatureEnum CONVERTED_TO_1 = TemperatureEnum.CELSIUS;

    @Autowired
    private HistoryService historyService;

    @MockBean
    private HistoryRepository historyRepository;

    @Before
    public void setUp() {
        List<History> historyList = new ArrayList<>();
        historyList.add(new History(ORIGINAL_VALUE, CONVERTED_VALUE, ORIGINAL_SCALE_TEMP, CONVERTED_TO));
        historyList.add(new History(ORIGINAL_VALUE_1, CONVERTED_VALUE_1, ORIGINAL_SCALE_TEMP_1, CONVERTED_TO_1));

        BDDMockito.given(this.historyRepository.findAll()).willReturn(historyList);
    }

    @Test
    public void shouldBeGetAll() {
        List<History> saved = historyService.findAll();
        assertEquals(2, saved.size());
    }

}

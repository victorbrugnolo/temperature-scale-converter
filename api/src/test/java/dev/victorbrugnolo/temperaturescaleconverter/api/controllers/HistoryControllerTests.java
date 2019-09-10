package dev.victorbrugnolo.temperaturescaleconverter.api.controllers;

import dev.victorbrugnolo.temperaturescaleconverter.api.entities.History;
import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;
import dev.victorbrugnolo.temperaturescaleconverter.api.services.HistoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class HistoryControllerTests {

    private static final String URL = "/api/history";

    private static final double ORIGINAL_VALUE = 50;
    private static final double CONVERTED_VALUE = 122;
    private static final TemperatureEnum ORIGINAL_SCALE_TEMP = TemperatureEnum.CELSIUS;
    private static final TemperatureEnum CONVERTED_TO = TemperatureEnum.FARENHEIT;
    private static final double ORIGINAL_VALUE_1 = 122;
    private static final double CONVERTED_VALUE_1 = 50;
    private static final TemperatureEnum ORIGINAL_SCALE_TEMP_1 = TemperatureEnum.FARENHEIT;
    private static final TemperatureEnum CONVERTED_TO_1 = TemperatureEnum.CELSIUS;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HistoryService historyService;

    @Before
    public void setUp() {
        List<History> historyList = new ArrayList<>();
        historyList.add(new History(ORIGINAL_VALUE, CONVERTED_VALUE, ORIGINAL_SCALE_TEMP, CONVERTED_TO));
        historyList.add(new History(ORIGINAL_VALUE_1, CONVERTED_VALUE_1, ORIGINAL_SCALE_TEMP_1, CONVERTED_TO_1));

        BDDMockito.given(historyService.findAll()).willReturn(historyList);
    }

    @Test
    public void shouldBeGetAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

}

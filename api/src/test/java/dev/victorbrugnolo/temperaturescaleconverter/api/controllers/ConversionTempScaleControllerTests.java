package dev.victorbrugnolo.temperaturescaleconverter.api.controllers;

import dev.victorbrugnolo.temperaturescaleconverter.api.dtos.ConvertedTemperatureResponse;
import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;
import dev.victorbrugnolo.temperaturescaleconverter.api.services.ConversionTempScaleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ConversionTempScaleControllerTests {

    private static final String URL = "/api/convert";
    private ConvertedTemperatureResponse toFarenheit = new ConvertedTemperatureResponse();
    private ConvertedTemperatureResponse toCelsius = new ConvertedTemperatureResponse();

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ConversionTempScaleService conversionTempScaleService;

    @Before
    public void setUp() {
        toFarenheit.setConvertedValue(70.00);
        toCelsius.setConvertedValue(57.01);

        BDDMockito.given(conversionTempScaleService.convert(Mockito.anyDouble(), eq(TemperatureEnum.FARENHEIT))).willReturn(toFarenheit);
        BDDMockito.given(conversionTempScaleService.convert(Mockito.anyDouble(), eq(TemperatureEnum.CELSIUS))).willReturn(toCelsius);
//        BDDMockito.given(conversionTempScaleService.convert(Mockito.anyDouble(), Mockito.any())).willThrow(MethodArgumentTypeMismatchException.class);
    }

    @Test
    public void shouldBeConvertToFarenheit() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(URL + "?temperature=10&convertTo=FARENHEIT").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.convertedValue").value(toFarenheit.getConvertedValue()));
    }

    @Test
    public void shouldBeConvertToCelsius() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(URL + "?temperature=10&convertTo=CELSIUS").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.convertedValue").value(toCelsius.getConvertedValue()));
    }

    @Test
    public void shouldBeException() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(URL + "?temperature=10&convertTo=ERROR").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Invalid field value"))
                .andExpect(jsonPath("$.field").value("convertTo"));

    }

}

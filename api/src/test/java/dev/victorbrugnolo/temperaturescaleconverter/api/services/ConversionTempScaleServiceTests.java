package dev.victorbrugnolo.temperaturescaleconverter.api.services;

import dev.victorbrugnolo.temperaturescaleconverter.api.dtos.ConvertedTemperatureResponse;
import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ConversionTempScaleServiceTests {

    @Autowired
    ConversionTempScaleService conversionTempScaleService;

    @Test
    public void shouldBeConvertFromCelsiusToFarenheit() {
        ConvertedTemperatureResponse converted = conversionTempScaleService.convert(35, TemperatureEnum.FARENHEIT);
        assertEquals(95.00000, converted.getConvertedValue(), 0.1);
    }

    @Test
    public void shouldBeConvertFromFarenheitToCelsius() {
        ConvertedTemperatureResponse converted = conversionTempScaleService.convert(15, TemperatureEnum.CELSIUS);
        assertEquals(-9.444444, converted.getConvertedValue(), 0.1);
    }

}

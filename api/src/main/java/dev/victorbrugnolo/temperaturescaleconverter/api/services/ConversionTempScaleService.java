package dev.victorbrugnolo.temperaturescaleconverter.api.services;

import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;
import dev.victorbrugnolo.temperaturescaleconverter.api.temperatures.Celsius;
import dev.victorbrugnolo.temperaturescaleconverter.api.temperatures.Farenheit;
import org.springframework.stereotype.Service;

@Service
public class ConversionTempScaleService {

    public Double convert(double temperature, TemperatureEnum convertTo) {

        switch (convertTo) {
            case CELSIUS:
                return new Celsius().convert(temperature);
            case FARENHEIT:
                return new Farenheit().convert(temperature);
            default:
                return 0D;
        }

    }

}

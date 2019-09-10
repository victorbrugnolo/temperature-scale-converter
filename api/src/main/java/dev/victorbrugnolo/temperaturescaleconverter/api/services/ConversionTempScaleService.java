package dev.victorbrugnolo.temperaturescaleconverter.api.services;

import dev.victorbrugnolo.temperaturescaleconverter.api.entities.History;
import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;
import dev.victorbrugnolo.temperaturescaleconverter.api.repositories.HistoryRepository;
import dev.victorbrugnolo.temperaturescaleconverter.api.temperatures.Celsius;
import dev.victorbrugnolo.temperaturescaleconverter.api.temperatures.Farenheit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionTempScaleService {

    @Autowired
    HistoryRepository historyRepository;

    public Double convert(double temperature, TemperatureEnum convertTo) {
        double convertedValue = 0D;

        switch (convertTo) {
            case CELSIUS:
                convertedValue = new Celsius().convert(temperature);
                historyRepository.save(new History(temperature, convertedValue, TemperatureEnum.FARENHEIT, TemperatureEnum.CELSIUS));
                return convertedValue;
            case FARENHEIT:
                convertedValue = new Farenheit().convert(temperature);
                historyRepository.save(new History(temperature, convertedValue, TemperatureEnum.CELSIUS, TemperatureEnum.FARENHEIT));
                return convertedValue ;
            default:
                return 0D;
        }

    }

}

package dev.victorbrugnolo.temperaturescaleconverter.api.services;

import dev.victorbrugnolo.temperaturescaleconverter.api.dtos.ConvertedTemperatureResponse;
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

    public ConvertedTemperatureResponse convert(double temperature, TemperatureEnum convertTo) {
        ConvertedTemperatureResponse convertedValue = new ConvertedTemperatureResponse();

        switch (convertTo) {
            case CELSIUS:
                convertedValue.setConvertedValue(new Celsius().convert(temperature));
                historyRepository.save(new History(temperature, convertedValue.getConvertedValue(), TemperatureEnum.FARENHEIT, TemperatureEnum.CELSIUS));
                return convertedValue;
            case FARENHEIT:
                convertedValue.setConvertedValue(new Farenheit().convert(temperature));
                historyRepository.save(new History(temperature, convertedValue.getConvertedValue(), TemperatureEnum.CELSIUS, TemperatureEnum.FARENHEIT));
                return convertedValue ;
            default:
                throw new IllegalArgumentException();
        }

    }

}

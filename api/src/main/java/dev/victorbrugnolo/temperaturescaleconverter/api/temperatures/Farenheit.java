package dev.victorbrugnolo.temperaturescaleconverter.api.temperatures;

import dev.victorbrugnolo.temperaturescaleconverter.api.temperatures.interfaces.Temperature;

public class Farenheit implements Temperature {

    @Override
    public double convert(double toConvert) {
        return (1.8 * toConvert) + 32;
    }
}

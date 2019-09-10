package dev.victorbrugnolo.temperaturescaleconverter.api.temperatures;

import dev.victorbrugnolo.temperaturescaleconverter.api.temperatures.interfaces.Temperature;

public class Celsius implements Temperature {
    @Override
    public double convert(double toConvert) {
        return (toConvert - 32) / 1.8;
    }
}

package dev.victorbrugnolo.temperaturescaleconverter.api.entities;

import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "original_value")
    private double originalValue;

    @NotNull
    @Column(name = "converted_value")
    private double convertedValue;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "original_scale_temp")
    @NotNull
    private TemperatureEnum originalScaleTemp;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "convertedTo")
    @NotNull
    private TemperatureEnum convertedTo;

    public History() {
    }

    public History(@NotNull double originalValue, @NotNull double convertedValue, @NotNull TemperatureEnum originalScaleTemp, @NotNull TemperatureEnum convertedTo) {
        this.originalValue = originalValue;
        this.convertedValue = convertedValue;
        this.originalScaleTemp = originalScaleTemp;
        this.convertedTo = convertedTo;
    }

    public Integer getId() {
        return id;
    }

    public double getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(double originalValue) {
        this.originalValue = originalValue;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public TemperatureEnum getOriginalScaleTemp() {
        return originalScaleTemp;
    }

    public void setOriginalScaleTemp(TemperatureEnum originalScaleTemp) {
        this.originalScaleTemp = originalScaleTemp;
    }

    public TemperatureEnum getConvertedTo() {
        return convertedTo;
    }

    public void setConvertedTo(TemperatureEnum convertedTo) {
        this.convertedTo = convertedTo;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", originalValue=" + originalValue +
                ", convertedValue=" + convertedValue +
                ", originalScaleTemp='" + originalScaleTemp + '\'' +
                ", convertedTo='" + convertedTo + '\'' +
                '}';
    }
}

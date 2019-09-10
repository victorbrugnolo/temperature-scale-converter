package dev.victorbrugnolo.temperaturescaleconverter.api.controllers;

import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;
import dev.victorbrugnolo.temperaturescaleconverter.api.services.ConversionTempScaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/convert")
@CrossOrigin(origins = "*")
public class ConversionTempScaleController {

    @Autowired
    ConversionTempScaleService conversionService;

    @GetMapping
    public ResponseEntity<Double> convert(@RequestParam("temperature") double temperature,
                                          @RequestParam("convertTo") TemperatureEnum convertTo) {
        return ResponseEntity.ok(conversionService.convert(temperature, convertTo));
    }

}

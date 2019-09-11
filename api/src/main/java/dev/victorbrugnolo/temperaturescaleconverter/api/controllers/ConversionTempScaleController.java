package dev.victorbrugnolo.temperaturescaleconverter.api.controllers;

import dev.victorbrugnolo.temperaturescaleconverter.api.dtos.ConvertedTemperatureResponse;
import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;
import dev.victorbrugnolo.temperaturescaleconverter.api.services.ConversionTempScaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Converter", description = "REST API for convert temperature scales", tags = { "Convert" })
@RequestMapping("/api/convert")
@CrossOrigin(origins = "*")
public class ConversionTempScaleController {

    @Autowired
    ConversionTempScaleService conversionService;

    @GetMapping
    @ApiOperation(value = "Convert from Farenheit to Celsius and vice versa")
    public ResponseEntity<ConvertedTemperatureResponse> convert(@RequestParam("temperature") double temperature,
                                                                @RequestParam("convertTo") TemperatureEnum convertTo) {
        return ResponseEntity.ok(conversionService.convert(temperature, convertTo));
    }

}

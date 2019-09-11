package dev.victorbrugnolo.temperaturescaleconverter.api.controllers;

import dev.victorbrugnolo.temperaturescaleconverter.api.entities.History;
import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;
import dev.victorbrugnolo.temperaturescaleconverter.api.services.ConversionTempScaleService;
import dev.victorbrugnolo.temperaturescaleconverter.api.services.HistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "History", description = "REST API for get history of conversions", tags = { "History" })
@RequestMapping("/api/history")
@CrossOrigin(origins = "*")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping
    @ApiOperation(value = "Get list from all conversions realized")
    public ResponseEntity<List<History>> findAll() {
        return ResponseEntity.ok(historyService.findAll());
    }
}

package dev.victorbrugnolo.temperaturescaleconverter.api.controllers;

import dev.victorbrugnolo.temperaturescaleconverter.api.entities.History;
import dev.victorbrugnolo.temperaturescaleconverter.api.enums.TemperatureEnum;
import dev.victorbrugnolo.temperaturescaleconverter.api.services.ConversionTempScaleService;
import dev.victorbrugnolo.temperaturescaleconverter.api.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "*")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping
    public ResponseEntity<List<History>> findAll() {
        return ResponseEntity.ok(historyService.findAll());
    }
}

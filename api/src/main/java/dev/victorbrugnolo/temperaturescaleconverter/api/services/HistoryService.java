package dev.victorbrugnolo.temperaturescaleconverter.api.services;

import dev.victorbrugnolo.temperaturescaleconverter.api.entities.History;
import dev.victorbrugnolo.temperaturescaleconverter.api.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    public List<History> findAll() {
        return historyRepository.findAll();
    }

}

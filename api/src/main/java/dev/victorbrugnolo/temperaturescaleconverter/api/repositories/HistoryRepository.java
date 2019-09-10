package dev.victorbrugnolo.temperaturescaleconverter.api.repositories;

import dev.victorbrugnolo.temperaturescaleconverter.api.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface HistoryRepository extends JpaRepository<History, Integer> {
}

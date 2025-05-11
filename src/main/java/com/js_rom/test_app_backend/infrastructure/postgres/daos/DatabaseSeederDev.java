package com.js_rom.test_app_backend.infrastructure.postgres.daos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.js_rom.test_app_backend.infrastructure.postgres.entities.CorrectOptionEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.IncorrectOptionEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.OptionEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
// @Profile("dev")
public class DatabaseSeederDev {

    private final OptionRepository optionRepository;

    public DatabaseSeederDev(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
        this.deleteAllAndInitializeAndSeedDataBase();
    }

    public void deleteAllAndInitializeAndSeedDataBase() {
        this.deleteAllAndInitialize();
        this.seedDataBaseJava();
    }

    private void deleteAllAndInitialize() {
        this.optionRepository.deleteAll();
        log.warn("------- Delete All -----------");
        // this.databaseStarting.initialize();
    }

    private void seedDataBaseJava() {
        log.warn("------- Initial Load from JAVA -----------");
        OptionEntity[] options = {
            new CorrectOptionEntity("1", "Respuesta 1"),
            new IncorrectOptionEntity("2", "Respuesta 2"),
            new IncorrectOptionEntity("3", "Respuesta 3"),
            new IncorrectOptionEntity("4", "Respuesta 4")
        };
        this.optionRepository.saveAll(List.of(options));
    }
}

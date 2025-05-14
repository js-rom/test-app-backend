package com.js_rom.test_app_backend.infrastructure.postgres.daos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.js_rom.test_app_backend.infrastructure.postgres.entities.CorrectOptionEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.IncorrectOptionEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.OptionEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.SingleSelectionQuestionEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
// @Profile("dev")
public class DatabaseSeederDev {

    private final OptionRepository optionRepository;
    private final SingleSelectionQuestionRepository singleSelectionQuestionRepository;

    public DatabaseSeederDev(OptionRepository optionRepository, SingleSelectionQuestionRepository singleSelectionQuestionRepository) {
        this.optionRepository = optionRepository;
        this.singleSelectionQuestionRepository = singleSelectionQuestionRepository;
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
        log.warn("------- Load Options -----------");
        OptionEntity[] optionsSingleSelectionQuestion1 = {
            new CorrectOptionEntity("a", "Cuestionario 1 Respuesta 1"),
            new IncorrectOptionEntity("b", "Cuestionario 1 Respuesta 2"),
            new IncorrectOptionEntity("c", "Cuestionario 1 Respuesta 3"),
            new IncorrectOptionEntity("d", "Cuestionario 1 Respuesta 4")
        };
        this.optionRepository.saveAll(List.of(optionsSingleSelectionQuestion1));
        OptionEntity[] optionsSingleSelectionQuestion2 = {
            new IncorrectOptionEntity("e", "Cuestionario 2 Respuesta 1"),
            new CorrectOptionEntity("f", "Cuestionario 2 Respuesta 2"),
            new IncorrectOptionEntity("g", "Cuestionario 2 Respuesta 3"),
            new IncorrectOptionEntity("h", "Cuestionario 2 Respuesta 4")
        };
        this.optionRepository.saveAll(List.of(optionsSingleSelectionQuestion2));
        OptionEntity[] optionsSingleSelectionQuestion3 = {
            new IncorrectOptionEntity("i", "Cuestionario 3 Respuesta 1"),
            new IncorrectOptionEntity("j", "Cuestionario 3 Respuesta 2"),
            new CorrectOptionEntity("k", "Cuestionario 3 Respuesta 3"),
            new IncorrectOptionEntity("l", "Cuestionario 3 Respuesta 4")
        };
        this.optionRepository.saveAll(List.of(optionsSingleSelectionQuestion3));
        OptionEntity[] optionsSingleSelectionQuestion4 = {
            new IncorrectOptionEntity("m", "Cuestionario 4 Respuesta 1"),
            new IncorrectOptionEntity("n", "Cuestionario 4 Respuesta 2"),
            new IncorrectOptionEntity("o", "Cuestionario 4 Respuesta 3"),
            new CorrectOptionEntity("p", "Cuestionario 4 Respuesta 4")
        };
        this.optionRepository.saveAll(List.of(optionsSingleSelectionQuestion4));
        OptionEntity[] optionsSingleSelectionQuestion5 = {
            new CorrectOptionEntity("q", "Cuestionario 5 Respuesta 1"),
            new IncorrectOptionEntity("r", "Cuestionario 5 Respuesta 2"),
            new IncorrectOptionEntity("s", "Cuestionario 5 Respuesta 3"),
            new IncorrectOptionEntity("t", "Cuestionario 5 Respuesta 4")
        };
        this.optionRepository.saveAll(List.of(optionsSingleSelectionQuestion5));
        log.warn("------- Load Single Selection Questions -----------");

        SingleSelectionQuestionEntity[] questions = {
            new SingleSelectionQuestionEntity("a", "Cuestionario 1", List.of(optionsSingleSelectionQuestion1)),
            new SingleSelectionQuestionEntity("b", "Cuestionario 2", List.of(optionsSingleSelectionQuestion2)),
            new SingleSelectionQuestionEntity("c", "Cuestionario 3", List.of(optionsSingleSelectionQuestion3)),
            new SingleSelectionQuestionEntity("d", "Cuestionario 4", List.of(optionsSingleSelectionQuestion4)),
            new SingleSelectionQuestionEntity("e", "Cuestionario 5", List.of(optionsSingleSelectionQuestion5))
        };
        this.singleSelectionQuestionRepository.saveAll(List.of(questions));
        
    }
}

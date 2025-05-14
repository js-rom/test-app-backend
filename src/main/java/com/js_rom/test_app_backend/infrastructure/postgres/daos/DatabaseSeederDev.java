package com.js_rom.test_app_backend.infrastructure.postgres.daos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.js_rom.test_app_backend.infrastructure.postgres.entities.CorrectOptionEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.IncorrectOptionEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.OptionEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.QuestionaireEntity;
import com.js_rom.test_app_backend.infrastructure.postgres.entities.SingleSelectionQuestionEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
// @Profile("dev") // comented: apply to all profiles (pro, dev, test) not comented: apply only to dev
public class DatabaseSeederDev {

    private final OptionRepository optionRepository;
    private final SingleSelectionQuestionRepository singleSelectionQuestionRepository;
    private final QuestionaireRepository questionaireRepository;

    public DatabaseSeederDev(OptionRepository optionRepository, 
    SingleSelectionQuestionRepository singleSelectionQuestionRepository,
    QuestionaireRepository questionaireRepository) {
        this.optionRepository = optionRepository;
        this.singleSelectionQuestionRepository = singleSelectionQuestionRepository;
        this.questionaireRepository = questionaireRepository;
        this.deleteAllAndInitializeAndSeedDataBase();
    }

    public void deleteAllAndInitializeAndSeedDataBase() {
        this.deleteAllAndInitialize();
        this.seedDataBaseJava();
    }

    private void deleteAllAndInitialize() {
        this.questionaireRepository.deleteAll();
        this.singleSelectionQuestionRepository.deleteAll();
        this.optionRepository.deleteAll();
        log.warn("------- Delete All -----------");
        // this.databaseStarting.initialize();
    }

    private void seedDataBaseJava() {
        log.warn("------- Initial Load from JAVA -----------");
        log.warn("------- Load Options -----------");
        OptionEntity[] optionsSingleSelectionQuestion1 = {
            new CorrectOptionEntity("a", "Pregunta 1 Respuesta 1"),
            new IncorrectOptionEntity("b", "Pregunta 1 Respuesta 2"),
            new IncorrectOptionEntity("c", "Pregunta 1 Respuesta 3"),
            new IncorrectOptionEntity("d", "Pregunta 1 Respuesta 4")
        };
        this.optionRepository.saveAll(List.of(optionsSingleSelectionQuestion1));
        OptionEntity[] optionsSingleSelectionQuestion2 = {
            new IncorrectOptionEntity("e", "Pregunta 2 Respuesta 1"),
            new CorrectOptionEntity("f", "Pregunta 2 Respuesta 2"),
            new IncorrectOptionEntity("g", "Pregunta 2 Respuesta 3"),
            new IncorrectOptionEntity("h", "Pregunta 2 Respuesta 4")
        };
        this.optionRepository.saveAll(List.of(optionsSingleSelectionQuestion2));
        OptionEntity[] optionsSingleSelectionQuestion3 = {
            new IncorrectOptionEntity("i", "Pregunta 3 Respuesta 1"),
            new IncorrectOptionEntity("j", "Pregunta 3 Respuesta 2"),
            new CorrectOptionEntity("k", "Pregunta 3 Respuesta 3"),
            new IncorrectOptionEntity("l", "Pregunta 3 Respuesta 4")
        };
        this.optionRepository.saveAll(List.of(optionsSingleSelectionQuestion3));
        OptionEntity[] optionsSingleSelectionQuestion4 = {
            new IncorrectOptionEntity("m", "Pregunta 4 Respuesta 1"),
            new IncorrectOptionEntity("n", "Pregunta 4 Respuesta 2"),
            new IncorrectOptionEntity("o", "Pregunta 4 Respuesta 3"),
            new CorrectOptionEntity("p", "Pregunta 4 Respuesta 4")
        };
        this.optionRepository.saveAll(List.of(optionsSingleSelectionQuestion4));
        OptionEntity[] optionsSingleSelectionQuestion5 = {
            new CorrectOptionEntity("q", "Pregunta 5 Respuesta 1"),
            new IncorrectOptionEntity("r", "Pregunta 5 Respuesta 2"),
            new IncorrectOptionEntity("s", "Pregunta 5 Respuesta 3"),
            new IncorrectOptionEntity("t", "Pregunta 5 Respuesta 4")
        };
        this.optionRepository.saveAll(List.of(optionsSingleSelectionQuestion5));
        
        log.warn("------- Load Single Selection Questions -----------");
        SingleSelectionQuestionEntity[] questions = {
            new SingleSelectionQuestionEntity("a", "Pregunta 1", List.of(optionsSingleSelectionQuestion1)),
            new SingleSelectionQuestionEntity("b", "Pregunta 2", List.of(optionsSingleSelectionQuestion2)),
            new SingleSelectionQuestionEntity("c", "Pregunta 3", List.of(optionsSingleSelectionQuestion3)),
            new SingleSelectionQuestionEntity("d", "Pregunta 4", List.of(optionsSingleSelectionQuestion4)),
            new SingleSelectionQuestionEntity("e", "Pregunta 5", List.of(optionsSingleSelectionQuestion5))
        };
        this.singleSelectionQuestionRepository.saveAll(List.of(questions));
        
        log.warn("------- Load Questionaires -----------");
        QuestionaireEntity[] questionaires = {
            new QuestionaireEntity("a", "Cuestionario 1", List.of(questions[0], questions[1], questions[2])),
            new QuestionaireEntity("b", "Cuestionario 2", List.of(questions[3], questions[4]))
        };
        this.questionaireRepository.saveAll(List.of(questionaires));
    }
}

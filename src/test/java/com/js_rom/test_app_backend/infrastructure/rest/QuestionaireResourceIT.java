package com.js_rom.test_app_backend.infrastructure.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.js_rom.test_app_backend.domain.models.CorrectOption;
import com.js_rom.test_app_backend.domain.models.IncorrectOption;
import com.js_rom.test_app_backend.domain.models.Option;
import com.js_rom.test_app_backend.domain.models.Questionaire;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

import static org.assertj.core.api.Assertions.assertThat;

@RestTestConfig
class QuestionaireResourceIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl() {
        return "http://localhost:" + port + QuestionaireResource.QUESTIONAIRE;
    }

    @Test
    void testCreate() {
        Option[] optionsSingleSelectionQuestion6 = {
                new CorrectOption("u", "Pregunta 6 Respuesta 1"),
                new IncorrectOption("v", "Pregunta 6 Respuesta 2"),
                new IncorrectOption("w", "Pregunta 6 Respuesta 3"),
                new IncorrectOption("x", "Pregunta 6 Respuesta 4")
        };
        Option[] optionsSingleSelectionQuestion7 = {
                new IncorrectOption("y", "Pregunta 7 Respuesta 1"),
                new CorrectOption("z", "Pregunta 7 Respuesta 2"),
                new IncorrectOption("aa", "Pregunta 7 Respuesta 3"),
                new IncorrectOption("bb", "Pregunta 7 Respuesta 4")
        };

        SingleSelectionQuestion[] questions = {
                new SingleSelectionQuestion("f", "Pregunta 6", List.of(optionsSingleSelectionQuestion6)),
                new SingleSelectionQuestion("g", "Pregunta 7", List.of(optionsSingleSelectionQuestion7))
        };

        Questionaire questionaire = Questionaire.builder()
                .description("Cuestionario 3")
                .singleSelectionQuestion(questions[0])
                .singleSelectionQuestion(questions[1]).build();

        ResponseEntity<Questionaire> response = restTemplate.postForEntity(baseUrl(), questionaire, Questionaire.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals(Questionaire.class, response.getBody().getClass());
        assertEquals("Cuestionario 3", response.getBody().getDescription());
        assertNotNull(response.getBody().getId());
    }

}

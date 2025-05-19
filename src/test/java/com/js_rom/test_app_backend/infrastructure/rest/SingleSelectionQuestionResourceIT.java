package com.js_rom.test_app_backend.infrastructure.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.js_rom.test_app_backend.domain.models.CorrectOption;
import com.js_rom.test_app_backend.domain.models.IncorrectOption;
import com.js_rom.test_app_backend.domain.models.Option;
import com.js_rom.test_app_backend.domain.models.SingleSelectionQuestion;

import static org.assertj.core.api.Assertions.assertThat;

@RestTestConfig
class SingleSelectionQuestionResourceIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl() {
        return "http://localhost:" + port + SingleSelectionQuestionResource.SINGLE_SELECTION_QUESTION;
    }

    @Test
    void testUpdate() {
        Option[] updatedOptions = {
                new IncorrectOption("anew", "Pregunta 1 Respuesta 1 actualizada incorrecta"),
                new IncorrectOption("bnew", "Pregunta 1 Respuesta 2 actualizada incorrecta"),
                new IncorrectOption("cnew", "Pregunta 1 Respuesta 3 actualizada incorrecta"),
                new CorrectOption("dnew", "Pregunta 1 Respuesta 4 actualizada correcta")
        };

        SingleSelectionQuestion singleSelectionQuestion = new SingleSelectionQuestion("a", "Pregunta 1 actualizada",
                List.of(updatedOptions));

        SingleSelectionQuestionDto dto = new SingleSelectionQuestionDto(singleSelectionQuestion);

        String url = baseUrl().replace("{questionaireId}", "a")
                + SingleSelectionQuestionResource.ID_ID.replace("{id}", "a");
        ResponseEntity<SingleSelectionQuestionDto> response = restTemplate.exchange(url, HttpMethod.PUT,
                new HttpEntity<>(dto), SingleSelectionQuestionDto.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertNotNull(response.getBody());
        assertEquals("a", response.getBody().getId());
        assertEquals(4, response.getBody().getOptions().size());
        assertEquals("Pregunta 1 actualizada", response.getBody().getDescription());
        assertEquals(3, response.getBody().getCorrectOptionIndex());
        assertEquals("Pregunta 1 Respuesta 4 actualizada correcta",
                response.getBody().getOptions().get(3).getDescription());
    }

    @Test
    void testDelete() {
        String url = baseUrl().replace("{questionaireId}", "a")
                + SingleSelectionQuestionResource.ID_ID.replace("{id}", "b");
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}

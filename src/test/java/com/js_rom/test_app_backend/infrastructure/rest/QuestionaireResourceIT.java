package com.js_rom.test_app_backend.infrastructure.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
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
                                new CorrectOption("cc", "Pregunta 8 Respuesta 1"),
                                new IncorrectOption("dd", "Pregunta 8 Respuesta 2"),
                                new IncorrectOption("ee", "Pregunta 8 Respuesta 3"),
                                new IncorrectOption("ff", "Pregunta 8 Respuesta 4")
                };
                Option[] optionsSingleSelectionQuestion7 = {
                                new IncorrectOption("gg", "Pregunta 9 Respuesta 1"),
                                new CorrectOption("hh", "Pregunta 9 Respuesta 2"),
                                new IncorrectOption("ii", "Pregunta 9 Respuesta 3"),
                                new IncorrectOption("jj", "Pregunta 9 Respuesta 4")
                };

                SingleSelectionQuestion[] questions = {
                                new SingleSelectionQuestion("h", "Pregunta 8",
                                                List.of(optionsSingleSelectionQuestion6)),
                                new SingleSelectionQuestion("i", "Pregunta 9", List.of(optionsSingleSelectionQuestion7))
                };

                Questionaire questionaire = Questionaire.builder()
                                .description("Cuestionario 4")
                                .singleSelectionQuestion(questions[0])
                                .singleSelectionQuestion(questions[1]).build();

                QuestionaireDto questionaireDto = new QuestionaireDto(questionaire);
                ResponseEntity<QuestionaireDto> response = restTemplate.postForEntity(baseUrl(), questionaireDto,
                                QuestionaireDto.class);

                assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
                assertNotNull(response.getBody());
                assertEquals(QuestionaireDto.class, response.getBody().getClass());
                assertEquals("Cuestionario 4", response.getBody().getDescription());
                assertNotNull(response.getBody().getId());
                assertEquals(2, response.getBody().getSingleSelectionQuestions().size());
                assertEquals(4, response.getBody().getSingleSelectionQuestions().get(0).getOptions().size());
                assertEquals("hh",
                                response.getBody().getSingleSelectionQuestions().get(1).getOptions().get(1).getId());
        }

        @Test
        void testDelete() {
                String url = baseUrl() + QuestionaireResource.ID_ID.replace("{id}", "b");
                ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
                assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        }

        @Test
        void testCreateQuestion() {

                Option[] optionsSingleSelectionQuestion = {
                                new IncorrectOption("kk", "Pregunta 10 Respuesta 1"),
                                new CorrectOption("ll", "Pregunta 10 Respuesta 2"),
                                new IncorrectOption("mm", "Pregunta 10 Respuesta 3"),
                                new IncorrectOption("nn", "Pregunta 10 Respuesta 4")
                };

                SingleSelectionQuestion newQuestion = new SingleSelectionQuestion("i", "Pregunta 10",
                                List.of(optionsSingleSelectionQuestion));
                SingleSelectionQuestionDto questionDto = new SingleSelectionQuestionDto(newQuestion);
                String url = baseUrl() + QuestionaireResource.ID_ID.replace("{id}", "a");
                ResponseEntity<SingleSelectionQuestionDto> response = restTemplate.postForEntity(url, questionDto,
                                SingleSelectionQuestionDto.class);

                assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
                assertNotNull(response.getBody());
                assertEquals(SingleSelectionQuestionDto.class, response.getBody().getClass());
                assertEquals("Pregunta 10", response.getBody().getDescription());
        }

        @Test
        void testReadAll() {
                ResponseEntity<BasicQuestionaireDto[]> response = restTemplate.getForEntity(baseUrl(),
                                BasicQuestionaireDto[].class);
                assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
                assertNotNull(response.getBody());
                assertEquals(BasicQuestionaireDto.class, response.getBody()[0].getClass());
        }

        @Test
        void getBasicQuestionaireBy() {
                String url = baseUrl() + QuestionaireResource.ID_ID.replace("{id}", "a");
                ResponseEntity<BasicQuestionaireDto> response = restTemplate.getForEntity(url,
                                BasicQuestionaireDto.class);
                assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
                assertNotNull(response.getBody());
                assertEquals("a", response.getBody().getId());
                assertEquals("Cuestionario 1", response.getBody().getDescription());
                assertEquals(BasicQuestionaireDto.class, response.getBody().getClass());
        }
}

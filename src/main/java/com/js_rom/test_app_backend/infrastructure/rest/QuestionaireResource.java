package com.js_rom.test_app_backend.infrastructure.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.js_rom.test_app_backend.domain.in_ports.QuestionaireServiceAdapter;
import com.js_rom.test_app_backend.domain.models.Questionaire;

@RestController
@RequestMapping(QuestionaireResource.QUESTIONAIRE)
public class QuestionaireResource {

    static final String QUESTIONAIRE = "/questionaires";

    QuestionaireServiceAdapter questionaireService;

    public QuestionaireResource(QuestionaireServiceAdapter questionaireService) {
        this.questionaireService = questionaireService;
    }

    @PostMapping
    public Questionaire create(@RequestBody Questionaire questionaire) {
        return this.questionaireService.create(questionaire);
    }
}

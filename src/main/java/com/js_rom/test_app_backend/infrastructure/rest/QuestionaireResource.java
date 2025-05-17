package com.js_rom.test_app_backend.infrastructure.rest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    static final String ID_ID = "/{id}";

    QuestionaireServiceAdapter questionaireService;

    public QuestionaireResource(QuestionaireServiceAdapter questionaireService) {
        this.questionaireService = questionaireService;
    }

    @PostMapping
    public QuestionaireDto create(@RequestBody QuestionaireDto questionaireDto) {
        Questionaire questionaire = questionaireDto.toQuestionaire();
        Questionaire questionaireOut = this.questionaireService.create(questionaire);
        return new QuestionaireDto(questionaireOut);
        //return new QuestionaireDto(this.questionaireService.create(questionaireDto.toQuestionaire()));
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.questionaireService.delete(id);
    }
}

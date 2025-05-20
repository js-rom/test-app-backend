package com.js_rom.test_app_backend.infrastructure.rest;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.js_rom.test_app_backend.domain.in_ports.QuestionaireServiceAdapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
        return new QuestionaireDto(this.questionaireService.create(questionaireDto.toQuestionaire()));
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.questionaireService.delete(id);
    }

    @PostMapping(ID_ID)
    public SingleSelectionQuestionDto createQuestion(@PathVariable String id, @RequestBody SingleSelectionQuestionDto questionDto) {
        return new SingleSelectionQuestionDto(
                this.questionaireService.create(id, questionDto.toSingleSelectionQuestion()));
    }

    @GetMapping()
    public List<BasicQuestionaireDto> readAll() {
        return this.questionaireService.readAll().stream()
            .map(BasicQuestionaireDto::new).toList();
    }
    
    @GetMapping(ID_ID)
    public List<SingleSelectionQuestionDto> readAllQuestionByQuestionaireId(@PathVariable String id) {
        return this.questionaireService.readAllQuestionByQuestionaireId(id).stream()
            .map(SingleSelectionQuestionDto::new).toList();
    }
}

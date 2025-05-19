package com.js_rom.test_app_backend.infrastructure.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.js_rom.test_app_backend.domain.in_ports.SingleSelectedQuestionServiceAdapter;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(SingleSelectionQuestionResource.SINGLE_SELECTION_QUESTION)
public class SingleSelectionQuestionResource {

    static final String SINGLE_SELECTION_QUESTION = "/questionaire/{questionaireId}/single-selection-questions";
    static final String ID_ID = "/{id}";

    SingleSelectedQuestionServiceAdapter singleSelectedQuestionService;

    public SingleSelectionQuestionResource(SingleSelectedQuestionServiceAdapter singleSelectedQuestionService) {
        this.singleSelectedQuestionService = singleSelectedQuestionService;
    }

    @PutMapping(ID_ID)
    public SingleSelectionQuestionDto update(@PathVariable String id, @RequestBody SingleSelectionQuestionDto Dto) {
        return new SingleSelectionQuestionDto(
                this.singleSelectedQuestionService.update(id, Dto.toSingleSelectionQuestion()));
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.singleSelectedQuestionService.delete(id);
    }

}
